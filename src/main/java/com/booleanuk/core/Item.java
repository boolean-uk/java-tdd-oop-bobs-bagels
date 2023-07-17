package com.booleanuk.core;

public class Item {

    private String SKU;
    private String name;
    private String variant;
    private double price;

    public Item(String SKU, String name, String variant, double price) {
        this.SKU = SKU;
        this.name = name;
        this.variant = variant;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getVariant() {
        return variant;
    }

    public double getPrice() {
        return price;
    }
}
