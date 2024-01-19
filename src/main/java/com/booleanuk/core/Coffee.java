package com.booleanuk.core;

import java.util.HashMap;

public class Coffee{
    private  String id;
    private String name;
    private double price;
    private String variant;


    public Coffee(String id, double price, String variant) {
        this.id = id;
        this.name = "Coffee";
        this.price = price;
        this.variant = variant;
    }

    public String getId() {
        return id;
    }
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getVariant() {
        return variant;
    }
}
