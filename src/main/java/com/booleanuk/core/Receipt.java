package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Receipt {
    private LocalDateTime date;
    private String pound = "\u00a3";

    public LocalDateTime getDate() {
        return date;
    }

    public String generateReceipt(Basket basket) {
        StringBuilder sb = new StringBuilder();

        //build date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();
        String formattedDateTime = dateTime.format(formatter);

        // Header
        sb.append("    ~~~ Bob's Bagels ~~~");
        sb.append("\n");
        sb.append("\n");
        sb.append("    "+formattedDateTime);
        sb.append("\n");
        sb.append("\n");
        sb.append("-".repeat(28));
        sb.append("\n");

        // Products
        for (Map.Entry<Product, Integer> entry : basket.getBasketList().entrySet()) {
            String variant = entry.getKey().getVariant();
            String name = entry.getKey().getName();
            int quantity = entry.getValue();
            double price = entry.getKey().getPrice();

            sb.append(String.format("%-18s %2d   %s%.2f\n", variant + " " + name, quantity, pound, price));
        }

        // Total Cost
        sb.append("-".repeat(28));
        sb.append("\n");
        sb.append("Total" + " ".repeat(18) + pound + basket.totalCost());
        sb.append("\n");
        sb.append("\n");

        sb.append(" ".repeat(8) + "Thank you" + "\n");
        sb.append(" ".repeat(6) + "for your order!");

        return sb.toString();
    }
}
