package com.booleanuk.core;

public class Product {
    private String name;
    private String sku;
    private double price;

    public Product(String name, String sku, double price) {
        this.name = name;
        this.sku = sku;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getSku() {
        return this.sku;
    }
}
