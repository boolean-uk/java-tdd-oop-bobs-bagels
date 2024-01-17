package com.booleanuk.core;

public class Coffee extends Item{
    public Coffee(String type, double price){
        super(type, price);
    }

    public String getType() {
        return type;
    }
    public double getPrice() {
        return price;
    }
}
