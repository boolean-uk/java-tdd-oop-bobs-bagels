package com.booleanuk.core;

public abstract class Item {
    private final String SKA;
    private final String name;

    public Item(String SKA, String name){
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
