package com.booleanuk.core;

public class Receipt {

    @Override
    public String toString() {
        return "    ~~~ Bob's Bagels ~~~   " +
                "\n" +
                "\n   2021-03-16 21:38:44 " +
                "\n" +
                "\n----------------------------" +
                "\n" +
                "\nPlain Bagel         1  \u00A30.39" +
                "\n" +
                "\n----------------------------" +
                "\nTotal                  \u00A30.39" +
                "\n" +
                "\n        Thank you" +
                "\n     for your order!";
    }
}
