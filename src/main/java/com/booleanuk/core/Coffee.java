package com.booleanuk.core;

public class Coffee {
    private String name;
    private String sku;
    private double price;

    public Coffee(String name, String sku, double price) {
        this.name = name;
        this.sku = sku;
        this.price = price;
    }

    public String getSku() {
        return this.sku;
    }
}
