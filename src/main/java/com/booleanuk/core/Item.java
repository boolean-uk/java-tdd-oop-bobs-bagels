package com.booleanuk.core;

import java.lang.reflect.Type;

public class Item {

    private String name;
    private String type;
    private String nametype;
    private double price;
    private int quantity;
    private String[] fillings;


    public Item(String name, String type, double price, int quantity) {
        this.name = name;
        this.type = type;
        this.nametype = name + " " + type;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(String name, String type, double price, int quantity, String[] fillings) {
        this.name = name;
        this.type = type;
        this.nametype = name + " " + type;
        this.quantity = quantity;
        this.price = price;
        this.fillings = fillings;
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

    public String getNametype() {
        return nametype;
    }

    public void setNametype(String nametype) {
        this.nametype = nametype;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String[] getFillings() {
        return fillings;
    }

    public void setFillings(String[] fillings) {
        this.fillings = fillings;
    }
}
