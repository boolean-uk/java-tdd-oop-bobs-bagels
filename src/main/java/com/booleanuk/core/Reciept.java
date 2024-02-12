package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class Reciept {

    private static final String RECEIPT_TOP = "~~~ Bob's Bagels ~~~";
    private static final String RECEIPT_BOTTOM = "Thank you\nfor your order!";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    private final static String SEPARATOR = "----------------------------";
    private static final String SAVED = "You saved a total of:";
    private List<RecieptItem> items;
    private LocalDateTime localDateTime;
    private Basket basket;

    public Reciept(List<RecieptItem> items){
        this.items = items;
        this.localDateTime = LocalDateTime.now();
        this.basket = new Basket(10);
    }

    private String format(double price){
        return String.format(Locale.ENGLISH, "%.2f", price);
    }

    public void getReceipt(){
        System.out.println(RECEIPT_TOP + "\n");
        System.out.println(localDateTime.format(DATE_TIME_FORMATTER) + "\n");
        System.out.println(SEPARATOR + "\n");

        for (RecieptItem item : items){
            System.out.println(item.getVariant() + " (" + item.getName() + ")\t" + item.getQuantity() + "\t£" + format(item.getTotalPrice()));
        }

        System.out.println("\n" + SEPARATOR);
        System.out.println("Total\t\t\t£" + format(basket.getTotalCost()));
        System.out.println("\n" + RECEIPT_BOTTOM);
        System.out.println(RECEIPT_TOP + "\n");
        System.out.println(localDateTime.format(DATE_TIME_FORMATTER));
        System.out.println(SEPARATOR);
        System.out.println(SAVED);
        System.out.println(format(basket.getDiscountPrice()));

    }
}
