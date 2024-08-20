// src/main/java/com/booleanuk/core/Receipt.java
package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Receipt {

    private final Order order;
    private final String dateTime;
    private final Inventory inventory;

    public Receipt(Order order) {
        this.order = order;
        this.inventory = order.getStore().getInventory();
        this.dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public Order getOrder() {
        return order;
    }

    private String formatItem(String name, int quantity, double price) {
        return String.format("%-16s %2d   £%.2f", name, quantity, price / 100);
    }

    private String formatTotal(double total) {
        return String.format("Total                 £%.2f", total / 100);
    }

    private String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < padding; i++) {
            sb.append(" ");
        }
        sb.append(text);
        return sb.toString();
    }

    public boolean printReceipt() {
        if (order.getTotalSum() == 0) {
            return false;
        }

        int receiptWidth = 30;

        System.out.println();
        System.out.println(centerText("~~~ " + order.getStore().getName() + " ~~~", receiptWidth));
        System.out.println();
        System.out.println(centerText(dateTime, receiptWidth));
        System.out.println();
        System.out.println("----------------------------");

        Map<String, Integer> productQuantities = new HashMap<>();
        Map<String, Double> productPrices = new HashMap<>();

        List<Product> basket = order.getBasket();
        for (Product product : basket) {
            String SKU = product.getSKU();
            productQuantities.put(SKU, productQuantities.getOrDefault(SKU, 0) + 1);
            productPrices.put(SKU, productPrices.getOrDefault(SKU, 0.0) + product.getPrice());
        }

        for (Map.Entry<String, Integer> entry : productQuantities.entrySet()) {
            String SKU = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.get(SKU);
            Product product = inventory.getProduct(SKU);
            System.out.println(formatItem(product.getVariant(), quantity, price));
            if (product instanceof Bagel bagel && !bagel.getFillings().isEmpty()) {
                for (Filling filling : bagel.getFillings()) {
                    System.out.println(String.format("  - %s           (£%.2f)", filling.getVariant(), filling.getPrice() / 100.0));
                }
            }
        }

        System.out.println("----------------------------");
        System.out.println(formatTotal(order.getTotalSum()));
        System.out.println();
        System.out.println(centerText("Thank you", receiptWidth));
        System.out.println(centerText("for your order!", receiptWidth));
        System.out.println();

        return true;
    }
}