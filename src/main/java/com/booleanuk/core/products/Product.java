package com.booleanuk.core.products;

public class Product {

    private final String SKU;
    private double price;

    public Product(String SKU, double price) {
        this.SKU = SKU;
        this.price = price;
    }

    public String getSKU() {
        return this.SKU;
    }

    public double getPrice() {
        return this.price;
    }

}
