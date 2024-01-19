package com.booleanuk.extension;

public class Filling {
    private String id;
    private String name;
    private double price;
    private String variant;

    public Filling(String id, double price, String variant) {
        this.id = id;
        this.name = "Filling";
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



