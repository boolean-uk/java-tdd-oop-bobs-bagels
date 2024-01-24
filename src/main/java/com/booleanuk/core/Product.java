package com.booleanuk.core;

public class Product {
    private String sku;
    private double price;
    private String name;
    private String variant;

    public Product(String sku, double price, String name, String variant) {
        this.setSku(sku);
        this.setPrice(price);
        this.setName(name);
        this.setVariant(variant);
    }

    // Setters currently never needed outside class
    private void setSku(String sku) {
        this.sku = sku;
    }
    private void setPrice(double price) {
        this.price = price;
    }
    private void setName(String name) {
        this.name = name;
    }
    private void setVariant(String variant) {
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
