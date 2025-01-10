package com.booleanuk.core;

public class Item {
    private String sku;
    private double price;
    private String name;
    private String variant;
    private int size;

    public Item(String sku, double price, String name, String variant, int size) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
        this.size = size;
    }

    public String getSku() {
        return sku;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getVariant() {
        return variant;
    }

    public int getSize() {
        return size;
    }
}
