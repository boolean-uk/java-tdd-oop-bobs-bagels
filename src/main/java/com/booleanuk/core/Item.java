package com.booleanuk.core;

public class Item {
    private String sku;
    private String name;
    private String variant;
    private double price;

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariant() {
        return this.variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public Item(String sku, String name, String variant, double price) {
        this.setSku(sku);
        this.setName(name);
        this.setVariant(variant);
        this.setPrice(price);
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
