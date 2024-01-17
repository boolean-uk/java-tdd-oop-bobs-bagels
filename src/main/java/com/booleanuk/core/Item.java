package com.booleanuk.core;

public abstract class Item {
    protected String type;
    protected double price;
    protected  String name;

    public Item(String name, String type, double price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    public String getType(){
        return this.type;
    }
    public double getPrice(){
        return this.price;
    }
    public String getName(){
        return this.name;
    }
}