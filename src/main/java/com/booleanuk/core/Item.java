package com.booleanuk.core;

public class Item {
    String SKU;
    double price;
    String type;
    String name;

    public Item(String SKU, double price, String type, String name) {
        this.SKU = SKU;
        this.price = price;
        this.type = type;
        this.name = name;
    }

    public String getSKU() {
        return this.SKU;
    }

    public double getPrice() {
        return this.price;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }
}
