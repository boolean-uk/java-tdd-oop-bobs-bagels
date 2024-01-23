package com.booleanuk.core;

public class Bagel implements Item {
    private String sku;
    private final String name;
    private String variant;
    private double price;

    public Bagel(String sku, String name, String variant, double price) {
        this.setSku(sku);
        this.name = "Bagel";
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
