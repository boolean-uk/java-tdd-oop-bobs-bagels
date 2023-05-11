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

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProductCost() {
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
}
