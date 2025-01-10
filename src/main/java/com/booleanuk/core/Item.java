package com.booleanuk.core;

import java.util.HashMap;

public class Item {
    private String id;
    private double price;
    private String type;
    private String description;

    public Item(String id, double price, String type, String description) {
        this.id = id;
        this.price = price;
        this.type = type;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
