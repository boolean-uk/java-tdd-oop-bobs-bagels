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



    public double getPrice() {
        return price;
    }



    public String getName() {
        return name;
    }


}


