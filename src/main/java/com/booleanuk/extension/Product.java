package com.booleanuk.extension;

public class Product {
    private String name;
    private double price;
    private String SKU;

    public Product(String name, double price, String SKU) {
        this.name = name;
        this.price = price;
        this.SKU = SKU;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getSKU() {
        return SKU;
    }
}
