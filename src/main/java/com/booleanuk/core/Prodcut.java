package com.booleanuk.core;
public class Prodcut {

    private String id;
    private double price;
    private String name;
    private String variant;

    public Prodcut(String id, double price, String name, String variant) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }

    // Getters for the product properties
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
