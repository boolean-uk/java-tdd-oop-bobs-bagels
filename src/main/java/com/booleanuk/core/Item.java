package com.booleanuk.core;

public class Item {
    public String name;
    public String variant;
    private final double price;

    public Item(String name, String variant, double price) {
        this.name = name;
        this.variant = variant;
        this.price = price;
    }

    public double checkPrice() {
        return this.price;
    }
}
