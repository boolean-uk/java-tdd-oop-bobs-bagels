package com.booleanuk.core.models;

public class Item {
    private String SKU;
    private double price;
    private String variant;


    public Item(String variant, double price, String SKU) {
        this.SKU = SKU;
        this.price = price;
        this.variant = variant;
    }

    public double getPrice() {
        return price;
    }

    public String getSKU() {
        return SKU;
    }
}
