package com.booleanuk.core;

public class Item {
    private double price;
    private String name;
    private String type;
    private String nametype;

    public Item(double price, String name, String type) {
        this.price = price;
        this.name = name;
        this.type = type;
        this.nametype = name + " " + type;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getNametype() {
        return nametype;
    }
}
