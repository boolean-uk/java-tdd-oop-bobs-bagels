package com.booleanuk.extension;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrderServiceTest {

    private static String TWILIO_RECIPIENT_PHONE_NUMBER;
    static Order order;
    static OrderService orderService;

    @BeforeAll
    static void beforeAll() {
        orderService = OrderService.getInstance();

        try {
            Dotenv dotenv = Dotenv.configure().load();
            TWILIO_RECIPIENT_PHONE_NUMBER = dotenv.get("TWILIO_RECIPIENT_PHONE_NUMBER", "");
        } catch (DotenvException ignore) {
            TWILIO_RECIPIENT_PHONE_NUMBER = "";
        }

        Bagel BGLO = new Bagel("BGLO", BigDecimal.valueOf(0.49), "Onion");
        Bagel BGLP = new Bagel("BGLP", BigDecimal.valueOf(0.39), "Plain");
        Bagel BGLE = new Bagel("BGLE", BigDecimal.valueOf(0.49), "Everything");
        Coffee COFB = new Coffee("COFB", BigDecimal.valueOf(0.99), "Black");
        Filling FILE = new Filling("FILE", BigDecimal.valueOf(0.12), "Egg");

        Basket basket = new Basket(1000);

        IntStream.range(0, 6).forEach(i -> basket.add(BGLO));
        basket.add(BGLP);
        basket.add(BGLE);

        BGLE.setFillings(List.of(FILE));

        basket.add(COFB);

        order = new Order(basket);
    }

    @Test
    public void shouldReturnNotificationMessage() {
        String actual = orderService.getNotificationBody(new Receipt(order.getBasket()));
        String expected = getExpectedFormattedSummaryMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateOrderFromSMSText() {
        Order order = orderService.createOrderFromSMS("6 x BGLO, 1 x BGLP, 1 x BGLE + 1 x FILE, 1 x COFB");

        Map<String, List<Product>> products = order.getBasket().getProducts().stream().collect(Collectors.groupingBy(Product::getSku));

        Assertions.assertEquals(6, products.get("BGLO").size());
        Assertions.assertEquals(1, products.get("BGLP").size());
        Assertions.assertEquals(1, products.get("BGLE").size());

        List<Filling> BGLEFillings = ((Bagel) products.get("BGLE").get(0)).getFillings();
        Assertions.assertEquals(1, BGLEFillings.size());
        Assertions.assertEquals("FILE", BGLEFillings.get(0).getSku());

        Assertions.assertEquals(1, products.get("COFB").size());
    }

    @Test
    public void getMessagesShouldReturnMessages() {
        orderService.placeOrder(order, TWILIO_RECIPIENT_PHONE_NUMBER);
        List<String> actual = orderService.getMessages();

        String summaryMessageWithProductsOnly = getExpectedFormattedSummaryMessage().lines()
                .skip(9)
                .limit(7)
                .map(s -> s + "\n")
                .reduce("", String::concat);

        Assertions.assertTrue(actual.get(0).contains("Your order is being processed. ETA:"));
        Assertions.assertTrue(actual.get(0).contains(summaryMessageWithProductsOnly));

        try {
            mockSmsOrder();
            Assertions.assertTrue(actual.contains("6 x BGLO, 1 x BGLP, 1 x BGLE + 1 x FILE, 1 x COFB"));
            Assertions.assertTrue(actual.get(2).contains(summaryMessageWithProductsOnly));
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String getExpectedFormattedSummaryMessage() {
        LocalDateTime receiptTime = LocalDateTime.now();
        LocalDateTime deliveryTime = receiptTime.plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return String.format("""
                Your order is being processed. ETA: %s
                                
                Here's your receipt:
                    ~~~ Bob's Bagels ~~~
                                
                    %s
                                
                ----------------------------
                                
                Onion Bagel         6  £2.94
                                     (-£0.45)
                Plain Bagel         1  £0.39
                Everything Bagel    1  £0.49
                Egg Filling         1  £0.12
                Black Coffee        1  £0.99
                                     (-£0.13)
                                
                ----------------------------
                                
                Total                  £4.35
                                
                 You saved a total of £0.58
                        on this shop
                                
                         Thank you
                      for your order!""", deliveryTime.format(formatter), receiptTime.format(formatter));
    }

    private void mockSmsOrder() throws URISyntaxException, IOException, InterruptedException {
        String formData = String.format(
                "From=%s&Body=%s",
                URLEncoder.encode(TWILIO_RECIPIENT_PHONE_NUMBER, StandardCharsets.UTF_8),
                URLEncoder.encode("6 x BGLO, 1 x BGLP, 1 x BGLE + 1 x FILE, 1 x COFB", StandardCharsets.UTF_8));
        HttpRequest smsRequest = HttpRequest.newBuilder(new URI("http://localhost:4567/sms"))
                .POST(HttpRequest.BodyPublishers.ofString(formData))
                .setHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        httpClient.send(smsRequest, HttpResponse.BodyHandlers.ofString());
    }
}
