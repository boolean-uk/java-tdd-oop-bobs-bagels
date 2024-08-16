package com.booleanuk.core;

public class Product {
    private final String sku;
    private final int price;
    private final String variant;

    public Product(String sku, int price, String variant) {
        if (sku == null) {
            throw new IllegalArgumentException("SKU cannot be null");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (variant == null) {
            throw new IllegalArgumentException("Variant cannot be null");
        }
        this.sku = sku;
        this.price = price;
        this.variant = variant;
    }

    public int getPrice() {
        return price;
    }
}
