package com.booleanuk.extension;

public class ExtensionProduct {
    private String sku;
    private double price;
    private String name;
    private String variant;

    public ExtensionProduct(String sku, double price, String name, String variant) {
        this.sku = sku;
        this.price = price;
        this.name = name;
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