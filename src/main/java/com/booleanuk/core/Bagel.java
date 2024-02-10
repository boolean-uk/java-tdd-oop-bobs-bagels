package com.booleanuk.core;

public class Bagel {

    private String sku;
    private double price;
    private String variant;
    private String name;

    public Bagel(String sku, double price, String variant, String name) {
        this.sku = sku;
        this.price = price;
        this.variant = variant;
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
