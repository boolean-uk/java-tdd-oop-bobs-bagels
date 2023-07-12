package com.booleanuk.core;

public abstract class Product {
    private String SKU;
    private Double price;
    private String variant;

    public Product(String SKU, Double price, String variant){
        this.SKU = SKU;
        this.price = price;
        this.variant = variant;
    }

    public String getSKU() {
        return SKU;
    }

    public Double getPrice() {
        return price;
    }

    public String getVariant() {
        return variant;
    }
}
