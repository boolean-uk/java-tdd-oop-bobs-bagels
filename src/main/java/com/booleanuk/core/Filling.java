package com.booleanuk.core;

public class Filling {
    String name;
    String sku;
    double price;

    public Filling(String name, String sku) {
        this.name = name;
        this.sku = sku;
        this.price = 0.12;
    }
    public Filling(String name, String sku, double price) {
        this.name = name;
        this.sku = sku;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
