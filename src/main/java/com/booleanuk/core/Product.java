package com.booleanuk.core;

public class Product {
    private final String sku;
    private final float price;
    private final String name;
    private final String variant;

    public Product(String sku, float price, String name, String variant) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }

    public float getPrice() {
        return price;
    }
}
