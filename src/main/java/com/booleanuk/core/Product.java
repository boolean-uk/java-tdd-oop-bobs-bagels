package com.booleanuk.core;

public class Product {
    private String SKU;
    private String name;
    private double price;
    private String variant;

    public Product(String SKU, String name, double price, String variant) {
        this.SKU = SKU;
        this.name = name;
        this.price = price;
        this.variant = variant;
    }

    public String getSKU() {
        return SKU;
    }

    public String getName() {
        return name;
    }

    public double getProductCost() {
        return price;
    }

    public String getVariant() {
        return variant;
    }

}
