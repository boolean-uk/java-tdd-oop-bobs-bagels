package com.booleanuk.core;

public class Product {
    String sku;
    double price;
    String name;
    String variant;

    public Product(String sku, double price, String name, String variant) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }
}
