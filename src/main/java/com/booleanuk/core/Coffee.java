package com.booleanuk.core;

public class Coffee implements Item {
    private String Sku;
    private double price;
    private String name;
    private String type;

    // Constructors
    public Coffee(String Sku, double price, String name, String type) {
        this.setSku(Sku);
        this.setPrice(price);
        this.setName(name);
        this.setType(type);
    }

    public Coffee (String Sku) {
        this.setSku(Sku);
    }

    // Getters & Setters
    public String getSku() {
        return this.Sku;
    }

    public void setSku(String Sku) {
        this.Sku = Sku;
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

    public void setName(String name) { this.name = name; }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
