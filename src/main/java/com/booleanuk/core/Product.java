package com.booleanuk.core;

public abstract class Product {

    private String sku;
    private double price;
    private String name;
    private String variant;

    Product(String sku, double price, String name, String variant) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }

    private String getSku() {
        return this.sku;
    }

    public String retrieveSku() {
        return this.getSku();
    }

    private double getPrice() {
        return this.price;
    }

    public double retrievePrice() {
        return this.getPrice();
    }

    private String getName() {
        return this.name;
    }

    public String retrieveName() {
        return getName();
    }

    private String getVariant() {
        return this.variant;
    }

    public String retrieveVariant() {
        return this.getVariant();
    }
}
