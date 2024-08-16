package com.booleanuk.core;

public class Product {
    private double price;
    private String variant;
    private String SKU;

    Product(String SKU, double price, String variant) {
        this.price = price;
        this.variant = variant;
        this.SKU = SKU;

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


    public String getSKU() {
        return SKU;
    }

}
