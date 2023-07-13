package com.booleanuk.core;

public class Item {

    private String name;
    private String variant;
    private double price;

    public Item(String name, String variant, double price) {
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
