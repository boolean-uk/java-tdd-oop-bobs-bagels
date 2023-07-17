package com.booleanuk.core;

public class Filling {
    private String sku;
    private double price;
    private String name;

    public Filling(String sku, double price, String name) {
        this.sku = sku;
        this.price = price;
        this.name = name;
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
}
