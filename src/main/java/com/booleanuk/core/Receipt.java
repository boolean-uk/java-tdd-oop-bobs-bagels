package com.booleanuk.core;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Receipt {
    private static final String RECEIPT_HEADER = "~~~ Bob's Bagels ~~~";
    private static final String RECEIPT_FOOTER = "Thank you\nfor your order!";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    private static final String LINE_SEPARATOR = "----------------------------";

    private static final String RECEIPT_SAVED_MONEY = "You saved a total of:";
    private List<ReceiptItem> items;
    private LocalDateTime dateTime;

    private Basket basket;

    public Receipt(List<ReceiptItem> items) {
        this.items = items;
        this.dateTime = LocalDateTime.now();
        this.basket = new Basket(7);
    }

    public void printReceipt() {
        System.out.println(RECEIPT_HEADER + "\n");
        System.out.println(dateTime.format(DATE_TIME_FORMATTER) + "\n");
        System.out.println(LINE_SEPARATOR + "\n");

        for (ReceiptItem item : items) {
            System.out.println(item.getVariant() + " (" +item.getName() + ")\t" + item.getQuantity() + "\t£" + formatPrice(item.getTotalPrice()));
        }

        System.out.println("\n" + LINE_SEPARATOR);
        System.out.println("Total\t\t\t£" + formatPrice(basket.getTotalCost()));
        System.out.println("\n" + RECEIPT_FOOTER);
        System.out.println(RECEIPT_HEADER + "\n");
        System.out.println(dateTime.format(DATE_TIME_FORMATTER));
        System.out.println(LINE_SEPARATOR);
        System.out.println(RECEIPT_SAVED_MONEY);
        System.out.println(formatPrice(basket.getDiscountValue()));
    }

    private String formatPrice(double price) {
        return String.format(Locale.ENGLISH, "%.2f", price);
    }
}