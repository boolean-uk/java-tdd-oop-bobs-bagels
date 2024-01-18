package com.booleanuk.core;

public class Item {
    public String sku;
    public String name;
    public String variant;
    private final double price;

    public Item(String sku, String name, String variant, double price) {
        this.sku = sku;
        this.name = name;
        this.variant = variant;
        this.price = price;
    }

    public double checkPrice() {
        return this.price;
    }
}
