package com.booleanuk.core;

public class Filling extends Item{
    public Filling(String type, double price){
        super(type, price);
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
