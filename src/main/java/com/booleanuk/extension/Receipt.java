package com.booleanuk.extension;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class Receipt {
    private static final String LINE_SEPARATOR = "------------------------------";
    private static final String THANK_YOU_MESSAGE = "         Thank you\n      for your order!";

    private final Order order;

    public Receipt(Order order) {
        this.order = order;
    }

    public void printReceipt() {
        printStoreName();
        printCurrentDateTime();
        System.out.println(LINE_SEPARATOR);
        printItems();
        System.out.println(LINE_SEPARATOR);
        printTotalPrice();
        printSavingsMessage();
        printThankYouMessage();
    }

    private void printStoreName() {
        System.out.println("     ~~~ Bob's Bagels ~~~");
    }

    private void printCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(DateTimeFormatter.ofPattern("     yyyy-MM-dd HH:mm:ss"));
        System.out.println(formattedDateTime);
    }

    private void printItems() {
        Map<Item, Integer> items = order.getItems();

        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            BigDecimal price = item.getPrice().multiply(BigDecimal.valueOf(quantity));
            String line = String.format("%-8s%-10s %2d %7s", entry.getKey().getName(),
                    entry.getKey().getVariant(), quantity, formatPrice(price));
            System.out.println(line);
            printSavings(item);
        }
    }

    private void printSavings(Item item) {
        BigDecimal savings = BigDecimal.ZERO;

        List<Discount> discounts = order.getDiscounts().stream()
                .filter(discount -> (discount.getDiscountedItem().equals(item))
                        || (discount.getRelatedItem() != null && discount.getRelatedItem().equals(item)))
                .toList();

        if (!discounts.isEmpty()) {
            for (Discount discount : discounts) {
                if (discount.getDiscountedItem().equals(item)) {
                    savings = savings.add(discount.getDiscountedItemSavings());
                } else if (discount.getRelatedItem().equals(item)) {
                    savings = savings.add(discount.getRelatedItemSavings());
                }
            }
        }

        if (savings.compareTo(BigDecimal.ZERO) > 0) {
            String line = String.format("                      (-€%2s)", savings);
            System.out.println(line);
        }
    }

    private void printTotalPrice() {
        BigDecimal totalPrice = order.getTotalPriceAfterDiscount();
        System.out.printf("Total%24s%n", formatPrice(totalPrice));
    }

    private void printSavingsMessage() {
        if (order.getTotalSavings().compareTo(BigDecimal.ZERO) > 0) {
            System.out.printf("""
     
      You saved a total of €%2s
            on this shop
    """, order.getTotalSavings());
        }
    }

    private void printThankYouMessage() {
        System.out.println();
        System.out.println(THANK_YOU_MESSAGE);
    }

    private String formatPrice(BigDecimal price) {
        return "€" + price.setScale(2, RoundingMode.UNNECESSARY);
    }
}