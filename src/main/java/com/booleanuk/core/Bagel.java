package com.booleanuk.core;

public class Bagel extends Item {
    public Bagel(String variant, double price, String sku) {
        super("Bagel", price, sku, variant);
    }

    public String getBagelPrice() {
        return "This bagel costs " + getPrice();
    }
}
