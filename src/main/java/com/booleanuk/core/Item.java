package com.booleanuk.core;

public abstract class Item {
    protected String SKU;
    protected String type;
    protected double price;
    protected  String name;

    public Item(String SKU, String name, String type, double price) {
        this.SKU = SKU;
        this.type = type;
        this.name = name;
        this.price = price;
    }
    public String getSKU(){
        return this.SKU;
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