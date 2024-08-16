package com.booleanuk.core;

public abstract class Item {
    private final double price;
    private final String SKA;
    private final String name;

    public Item(double price, String SKA, String name){
        this.price = price;
        this.SKA = SKA;
        this.name = name;
    }

    public double getPrice(){
        return price;
    }

    public String getSka(){
        return SKA;
    }

    public String getName(){
        return name;
    }
}
