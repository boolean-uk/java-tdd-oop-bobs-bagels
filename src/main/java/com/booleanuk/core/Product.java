package com.booleanuk.core;

public class Product {

    private String sku;
    private String variant;
    private double price;

    public Product(String sku, String variant, double price){
        this.sku = sku;
        this.variant = variant;
        this.price = price;
    }
}
