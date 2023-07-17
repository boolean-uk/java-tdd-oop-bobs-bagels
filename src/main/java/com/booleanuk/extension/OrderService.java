package com.booleanuk.extension;

import com.twilio.Twilio;
import com.twilio.exception.AuthenticationException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import io.github.cdimascio.dotenv.Dotenv;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static spark.Spark.post;

public class OrderService {

    private static volatile OrderService instance;

    private final String TWILIO_ACCOUNT_SID;
    private final String TWILIO_AUTH_TOKEN;
    private final String TWILIO_FROM_NUMBER;

    private final List<Order> orders = new ArrayList<>();
    private final List<String> messages = new ArrayList<>();

    private OrderService() {
        Dotenv dotenv = Dotenv.configure().load();

        TWILIO_ACCOUNT_SID = dotenv.get("TWILIO_ACCOUNT_SID");
        TWILIO_AUTH_TOKEN = dotenv.get("TWILIO_AUTH_TOKEN");
        TWILIO_FROM_NUMBER = dotenv.get("TWILIO_FROM_NUMBER");

        try {
            Twilio.init(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);
        } catch (AuthenticationException ignored) {
           System.err.println("Can not authenticate to Twilio");
        }

        post("/sms", (req, res) -> {
            String fromNumber = req.queryParams("From");
            String message = req.queryParams("Body");
            messages.add(message);
            Order order = createOrderFromSMS(message);
            placeOrder(order, fromNumber);
            return "";
        });
    }

    public static OrderService getInstance() {
        if(instance != null)
            return instance;
        synchronized (OrderService.class) {
            if(instance == null)
                instance = new OrderService();
            return instance;
        }
    }

    public void placeOrder(Order order, String phoneNumber) {
        orders.add(order);
        String body = getNotificationBody(getReceipt(order));
        notifyCustomer(body, phoneNumber);
        messages.add(body);
    }

    public Receipt getReceipt(Order order) {
        return new Receipt(order.getBasket());
    }

    public void notifyCustomer(String messageBody, String phoneNumber) {
        try {
            Message.creator(
                    new PhoneNumber(phoneNumber),
                    new PhoneNumber(TWILIO_FROM_NUMBER),
                    messageBody
            ).create();
        } catch (AuthenticationException ignored) {
            System.err.println("Can not authenticate to Twilio");
        }
    }

    public String getNotificationBody(Receipt receipt) {
        StringBuilder sb = new StringBuilder();
        sb.append("Your order is being processed. ETA: ");

        LocalDateTime time = LocalDateTime.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        sb.append(time.format(formatter));
        sb.append("\n\n");
        sb.append("Here's your receipt:\n");
        sb.append(receipt.printReceipt());

        return sb.toString();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<String> getMessages() {
        return messages;
    }

    public Order createOrderFromSMS(String orderMessage) {
        Basket basket = new Basket(100);
        Order order = new Order(basket);

        String[] orderItems = orderMessage.split(", ");

        for(String orderItem : orderItems) {
            String[] s = orderItem.split(" \\+ ");
            String[] productItems = s[0].split(" x ");
            int productQuantity = Integer.parseInt(productItems[0]);
            String productSku = productItems[1];

            Product product = Inventory.getProduct(productSku);
            for(int i = 0; i < productQuantity; i++)
                basket.add(product);

            if(s.length > 1) {
                if(!productSku.startsWith("BGL"))
                    throw new IllegalArgumentException("Only bagels may have fillings");
                String[] fillingItems = s[1].split(" x ");
                int fillingQuantity = Integer.parseInt(fillingItems[0]);
                String fillingSku = fillingItems[1];

                if(!fillingSku.startsWith("FIL"))
                    throw new IllegalArgumentException(String.format("Product %s is not a filling", fillingSku));

                Filling filling = (Filling) Inventory.getProduct(fillingSku);
                Bagel bagel = (Bagel) product;

                List<Filling> fillings = new ArrayList<>(fillingQuantity);
                for(int i = 0; i < fillingQuantity; i++)
                    fillings.add(filling);

                bagel.setFillings(fillings);
            }
        }
        return order;
    }
}
