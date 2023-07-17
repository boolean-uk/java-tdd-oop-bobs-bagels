package com.booleanuk.extension;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import io.github.cdimascio.dotenv.Dotenv;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

        Twilio.init(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);
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
        notifyCustomer(order, phoneNumber);
    }

    public Receipt getReceipt(Order order) {
        return new Receipt(order.getBasket());
    }

    private void notifyCustomer(Order order, String phoneNumber) {
        String body = getNotificationBody(getReceipt(order));
        Message.creator(
                new PhoneNumber(phoneNumber),
                new PhoneNumber(TWILIO_FROM_NUMBER),
                body
        ).create();
        messages.add(body);
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
}
