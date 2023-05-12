package com.booleanuk.core;

public class Item {
    private String SKU;
    private double price;
    private String name;
    private String type;

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

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
