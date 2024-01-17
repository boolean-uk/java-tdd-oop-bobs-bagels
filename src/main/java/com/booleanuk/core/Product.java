package com.booleanuk.core;

public class Product {
    public String sku;
    public double price;
    public String name;
    public String variant;

    public Product(String sku, double price, String name, String variant) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
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
}
