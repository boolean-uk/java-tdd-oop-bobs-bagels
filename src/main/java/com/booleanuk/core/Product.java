package com.booleanuk.core;

public abstract class Product {
    protected String SKU;
    protected double price;
    protected String name;

    public Product(String SKU, double price, String name) {
        this.SKU = SKU;
        this.price = price;
        this.name = name;
    }

    public String getSKU() {
        return SKU;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    public abstract double applyDiscount();
}
