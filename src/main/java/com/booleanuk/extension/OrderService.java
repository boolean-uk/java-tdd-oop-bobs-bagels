package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private static volatile OrderService instance;

    private final List<Order> orders = new ArrayList<>();

    private OrderService() {
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

}
