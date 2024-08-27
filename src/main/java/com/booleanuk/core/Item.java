package com.booleanuk.core;

public class Item {

    private final String name;
    private final double price;
    private final String sku;


    public Item(String name, double price, String sku){

        this.name = name;
        this.price = price;
        this.sku = sku;

    }

    public String getSku() {

        return sku;

    }

    public String getName() {

        return name;

    }

    public double getPrice() {

        return price;

    }

}
