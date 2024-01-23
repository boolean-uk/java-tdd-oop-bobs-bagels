package com.booleanuk.core;

public class Coffee implements Item{
    private String sku;
    private final String name;
    private String variant;
    private double price;

    public Coffee(String sku, String variant, double price) {
        this.setSku(sku);
        this.name = "Coffee";
        this.setVariant(variant);
        this.setPrice(price);
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return this.name;
    }

    public String getVariant() {
        return this.variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
