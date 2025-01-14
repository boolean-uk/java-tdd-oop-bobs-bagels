package com.booleanuk.core;

public class Item {
    private final String id;
    private final double price;
    private final String description;

    public Item(String id, double price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
