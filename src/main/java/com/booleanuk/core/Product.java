package com.booleanuk.core;

public class Product {
    private double price;
    private String variant;
    private String SKU;
    Bagels bagels = new Bagels();
    Coffee coffe = new Coffee();
    Fillings fillings = new Fillings();

    Product(double price, String variant, String SKU) {
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

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }
}
