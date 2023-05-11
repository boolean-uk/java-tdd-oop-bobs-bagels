package com.booleanuk.core;

public class Item {
    String SKU;
    double price;
    String name;
    String type;

    public Item (String SKU, double price, String name, String type) {
        this.SKU = SKU;
        this.price = price;
        this.name = name;
        this.type = type;
    }

    public Item (String name, String type) {
        this.name = name;
        this.type = type;
    }
}
