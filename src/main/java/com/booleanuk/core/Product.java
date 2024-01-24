package com.booleanuk.core;

public class Product {
    private String itemName;
    private double price;
    private String sku;
    private String variant;

    public Product(String itemName, double price, String sku, String variant) {
        this.itemName = itemName;
        this.price = price;
        this.sku = sku;
        this.variant = variant;
    }

    public String getItemName() {
        return this.itemName;
    }

    public double getPrice() {
        return this.price;
    }
    public String getSku() {
        return this.sku;
    }

    public String getVariant() {
        return this.variant;
    }

    public String toString(){
        return this.sku;
    }
}