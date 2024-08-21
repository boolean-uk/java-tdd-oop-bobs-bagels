// src/main/java/com/booleanuk/core/Receipt.java
package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.*;

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

        Map<ArrayList<Product>, Integer> discountedProductsMap = order.getDiscountedProductsMap();
        Map<Product, Integer> nonDiscountedProductsMap = order.getNonDiscountedProductsMap();

        // Print discounted products
        for (Map.Entry<ArrayList<Product>, Integer> entry : discountedProductsMap.entrySet()) {
            ArrayList<Product> products = entry.getKey();
            int discountPrice = entry.getValue();
            int quantity = products.size();
            String productName = "Bagels";

            System.out.println(formatItem(productName, quantity, discountPrice));
        }

        // Print non-discounted products
        for (Map.Entry<Product, Integer> entry : nonDiscountedProductsMap.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            int price = product.getPrice() * quantity;

            if (product instanceof Bagel bagel && !bagel.getFillings().isEmpty()) {
                printProductWithFillings(bagel, quantity, price);
            } else {
                System.out.println(formatItem(product.getVariant(), quantity, price));
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

    private void printProductWithFillings(Bagel bagel, int quantity, int price) {
        System.out.println(formatItem(bagel.getVariant(), quantity, price));

            Map<Filling, Integer> fillingQuantities = new HashMap<>();
            for (Filling filling : bagel.getFillings()) {
                fillingQuantities.put(filling, fillingQuantities.getOrDefault(filling, 0) + quantity);
            }
            for (Map.Entry<Filling, Integer> entry : fillingQuantities.entrySet()) {
                String fillingName = entry.getKey().getVariant();
                int fillingQuantity = entry.getValue();
                System.out.printf("  - %s x%d       (£%.2f)%n", fillingName, fillingQuantity, entry.getKey().getPrice() / 100.0);

        }
    }
}