// src/main/java/com/booleanuk/core/Receipt.java
package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.*;

public class Receipt {

    private final Order order;
    private final String dateTime;

    public Receipt(Order order) {
        this.order = order;
        this.dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public Order getOrder() {
        return order;
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
        createHeader(receiptWidth);

        Map<Integer, Integer> twelveBagelDiscounts = order.getTwelveBagelDiscounts();
        Map<Integer, Integer> sixBagelDiscounts = order.getSixBagelDiscounts();
        Map<Integer, Integer> coffeeBagelPairsDiscount = order.getCoffeeBagelPairsDiscount();
        Map<Product, Integer> nonDiscountedProductsMap = order.getNonDiscountedProductsMap();

        if (!twelveBagelDiscounts.isEmpty() || !sixBagelDiscounts.isEmpty() || !coffeeBagelPairsDiscount.isEmpty()) {
            printDiscountSection(twelveBagelDiscounts, sixBagelDiscounts, coffeeBagelPairsDiscount);
        }
        printNonDiscountedProducts(nonDiscountedProductsMap);
        printFooter(receiptWidth);

        return true;
    }

    private void printFooter(int receiptWidth) {
        System.out.println("----------------------------");
        System.out.println(formatTotal(order.getTotalSum()));
        System.out.println();
        System.out.println(centerText("Thank you", receiptWidth));
        System.out.println(centerText("for your order!", receiptWidth));
        System.out.println();
    }

    private void printDiscountSection(Map<Integer, Integer> twelveBagelDiscounts, Map<Integer, Integer> sixBagelDiscounts, Map<Integer, Integer> coffeeBagelPairsDiscount) {
        printDiscounts(twelveBagelDiscounts, "12 Bagels", 399);
        printDiscounts(sixBagelDiscounts, "6 Bagels", 249);
        printDiscounts(coffeeBagelPairsDiscount, "Bagel + Coffee", 125);
    }

    private void printDiscountedHeader() {
            System.out.println();
            System.out.println("Discounted Products:");

    }

    private void printNonDiscountedProducts(Map<Product, Integer> nonDiscountedProductsMap) {
        for (Map.Entry<Product, Integer> entry : nonDiscountedProductsMap.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            int price = product.getPrice() * quantity;

            if (product instanceof Bagel bagel) {
                printProductWithFillings(bagel, quantity, price);
            } else {

            System.out.println(formatItem(product.getVariant(), quantity, price, 0));
        }
    }
}

    private void createHeader(int receiptWidth) {
        System.out.println();
        System.out.println(centerText("~~~ " + order.getStore().getName() + " ~~~", receiptWidth));
        System.out.println();
        System.out.println(centerText(dateTime, receiptWidth));
        System.out.println();
        System.out.println("----------------------------");
    }

    private void printDiscounts(Map<Integer, Integer> discounts, String itemName, int discountPrice) {
        for (Map.Entry<Integer, Integer> entry : discounts.entrySet()) {
            int quantity = entry.getKey();
            int totalCost = entry.getValue();
            int savings = totalCost - discountPrice * quantity;

            for (int i = 0; i < quantity; i++) {
                System.out.println(formatItem(itemName, 1, discountPrice, savings));
            }
        }
    }

    private void printProductWithFillings(Bagel bagel, int quantity, int price) {
        System.out.println(formatItem(bagel.getVariant(), quantity, price, 0));

        Map<Filling, Integer> fillingQuantities = new HashMap<>();
        for (Filling filling : bagel.getFillings()) {
            fillingQuantities.put(filling, fillingQuantities.getOrDefault(filling, 0) + quantity);
        }
        for (Map.Entry<Filling, Integer> entry : fillingQuantities.entrySet()) {
            String fillingName = entry.getKey().getVariant();
            int fillingQuantity = entry.getValue();
            System.out.printf(" -%-14s %2d   £%.2f%n", fillingName, fillingQuantity, (entry.getKey().getPrice() * fillingQuantity) / 100.0);
        }
    }

    private String formatItem(String name, int quantity, int price, int savings) {
        String itemLine = String.format("%-16s %2d   £%.2f", name, quantity, price / 100.0);
        String savingsLine = savings > 0 ? String.format("%19s(-£%.2f)", "", savings / 100.0) : "";
        return savingsLine.isEmpty() ? itemLine : itemLine + "\n" + savingsLine;
    }

    private String formatTotal(double total) {
        return String.format("Total                £%.2f", total / 100);
    }
}