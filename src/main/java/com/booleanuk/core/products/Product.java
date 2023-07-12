package com.booleanuk.core.products;

public abstract class Product {
    private String SKU;
    private double price;

    public Product(String SKU, double price) {
        this.SKU = SKU;
        this.price = price;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
