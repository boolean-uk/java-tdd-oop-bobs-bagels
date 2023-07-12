package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.Locale;

public class Checkout {
    public static void printReceipt(Basket basket) {
        String result = String.format(
            "~~~ Bob's Bagels ~~~\n\n" +
            "%s\n\n" +
            "--------------------\n" +
            "%s" +
            "\n--------------------\n" +
            "Total          %s\n\n" +
            "Thank you for your order!",
                LocalDateTime.now(),
                basket.toString(),
                Currency.getInstance(Locale.UK).getSymbol() + basket.totalCost()
        );
        System.out.println(result);
    }
}
