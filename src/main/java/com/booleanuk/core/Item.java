package com.booleanuk.core;

public abstract class Item {
    private String sku;
    private double price;
    private String name;

    public Item(String sku, double price, String name) {
        this.sku = sku;
        this.price = price;
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


