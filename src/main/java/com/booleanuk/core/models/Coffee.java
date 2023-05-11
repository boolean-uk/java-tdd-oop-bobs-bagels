package com.booleanuk.core.models;

public class Coffee {
    String variant;
    double price;
    String SKU;

    public Coffee(String variant, double price, String SKU) {
        this.variant = variant;
        this.price = price;
        this.SKU = SKU;
    }
}
