package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.*;

public class Receipt {

    private final Order order;
    private final String dateTime;
    private static final int BAGEL_COFFEE_PAIR_DISCOUNT_PRICE = 125;
    private static final int TWELVE_BAGEL_DISCOUNT_PRICE = 399;
    private static final int SIX_BAGEL_DISCOUNT_PRICE = 249;

    public Receipt(Order order) {
        this.order = order;
        this.dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public Order getOrder() {
        return order;
    }

    public boolean printReceipt() {
        if (order.getTotalSum() == 0) {
            return false;
        }

        int receiptWidth = 30;
        printHeader(receiptWidth);

        Map<Integer, Integer> twelveBagelDiscounts = order.getTwelveBagelDiscounts();
        Map<Integer, Integer> sixBagelDiscounts = order.getSixBagelDiscounts();
        Map<Integer, Integer> coffeeBagelPairsDiscount = order.getCoffeeBagelPairsDiscount();
        Map<Product, Integer> nonDiscountedProducts = order.getNonDiscountedProductsMap();

        int totalAmountOfSavings = 0;
        if (!twelveBagelDiscounts.isEmpty() || !sixBagelDiscounts.isEmpty() || !coffeeBagelPairsDiscount.isEmpty()) {
            totalAmountOfSavings += printDiscountedProducts(twelveBagelDiscounts, "12 Bagels", TWELVE_BAGEL_DISCOUNT_PRICE);
            totalAmountOfSavings += printDiscountedProducts(sixBagelDiscounts, "6 Bagels", SIX_BAGEL_DISCOUNT_PRICE);
            totalAmountOfSavings += printDiscountedProducts(coffeeBagelPairsDiscount, "Bagel + Coffee", BAGEL_COFFEE_PAIR_DISCOUNT_PRICE);
        }
        printNonDiscountedProducts(nonDiscountedProducts);
        printFooter(receiptWidth, totalAmountOfSavings);

        return true;
    }

    private String centerText(String text, int width) {
        // Calculate the padding needed to center the text within the given width.
        // Divided by 2 to get the padding for one side.
        int padding = (width - text.length()) / 2;
        return " ".repeat(Math.max(0, padding - 1)) + text;
    }

    private void printFooter(int receiptWidth, int totalAmountOfSavings) {
        System.out.println("----------------------------");
        System.out.println(formatTotal(order.getTotalSum()));
        System.out.println();
        System.out.println(centerText("You saved a total of £" + String.format("%.2f", totalAmountOfSavings / 100.0), receiptWidth));
        System.out.println(centerText("on this shop", receiptWidth));
        System.out.println();
        System.out.println(centerText("Thank you", receiptWidth));
        System.out.println(centerText("for your order!", receiptWidth));
        System.out.println();
    }

    private void printHeader(int receiptWidth) {
        System.out.println();
        System.out.println(centerText("~~~ " + order.getStore().getName() + " ~~~", receiptWidth));
        System.out.println();
        System.out.println(centerText(dateTime, receiptWidth));
        System.out.println();
        System.out.println("----------------------------");
    }

    private void printNonDiscountedProducts(Map<Product, Integer> nonDiscountedProducts) {
        for (Map.Entry<Product, Integer> entry : nonDiscountedProducts.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            int price = product.getPrice() * quantity;

            if (product instanceof Bagel bagel && !bagel.getFillings().isEmpty()) {
                printBagelWithFillings(bagel, quantity, price);
            } else {

            System.out.println(formatString(product.getVariant(), quantity, price, 0));
        }
    }
}

    private int printDiscountedProducts(Map<Integer, Integer> discounts, String itemName, int discountPrice) {
        int savings = 0;
        for (Map.Entry<Integer, Integer> entry : discounts.entrySet()) {
            int quantity = entry.getKey();
            int totalCost = entry.getValue();
            savings = totalCost - discountPrice * quantity;

            for (int i = 0; i < quantity; i++) {
                System.out.println(formatString(itemName, 1, discountPrice, savings));
            }
        }
        return savings;
    }

    private void printBagelWithFillings(Bagel bagel, int quantity, int price) {
        System.out.println(formatString(bagel.getVariant(), quantity, price, 0));

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

    private String formatString(String name, int quantity, int price, int savings) {
        String itemLine = String.format("%-16s %2d   £%.2f", name, quantity, price / 100.0);
        String savingsLine = savings > 0 ? String.format("%19s(-£%.2f)", "", savings / 100.0) : "";
        return savingsLine.isEmpty() ? itemLine : itemLine + "\n" + savingsLine;
    }

    private String formatTotal(int total) {
        return String.format("Total                £%.2f", total / 100.0);
    }
}