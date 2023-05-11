package com.booleanuk.core.models;

public class Filling {
    String variant;
    double price;
    String SKU;

    public Filling(String variant, String SKU) {
        this.variant = variant;
        this.price = 0.12;
        this.SKU = SKU;
    }

    public Filling(String variant, double price, String SKU) {
        this.variant = variant;
        this.price = price;
        this.SKU = SKU;
    }

    public double getPrice() {
        return price;
    }
}
