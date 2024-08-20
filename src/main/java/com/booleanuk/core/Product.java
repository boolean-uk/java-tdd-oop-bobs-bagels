package com.booleanuk.core;

import java.util.List;

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

    public String getVariant() {
        return variant;
    }

    public boolean addFilling(Filling filling) {
        return false;
    }

    public List<Filling> getFillings() {
        return null;
    }

    public String getSKU() {
        return sku;
    }

    public int getPrice() {
        return price;
    }
}
