package com.booleanuk.core;

class Item {
    protected String type;
    protected double price;

    public Item(String name, double price) {
        this.type = name;
        this.price = price;
    }
    public String getType(){
        return this.type;
    }
    public double getPrice(){
        return this.price;
    }
}