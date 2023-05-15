package com.booleanuk.core;

public class Item {
    private String SKU;
    private double price;
    private String name;
    private String type;

    // Constructors
    public Item (String SKU, double price, String name, String type) {
        this.setSKU(SKU);
        this.setPrice(price);
        this.setName(name);
        this.setType(type);
    }

    public Item (String name, String type) {
        this.setName(name);
        this.setType(type);
    }

    public Item (String SKU) {
        this.setSKU(SKU);
    }

    // Getters & Setters
    public String getSKU() {
        return this.SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
