package com.booleanuk.core.models;

public class Coffee {
    private String variant;
    private double price;
    private String SKU;

    public Coffee(String variant, double price, String SKU) {
        this.variant = variant;
        this.price = price;
        this.SKU = SKU;
    }
}
