package com.booleanuk.core;

public class Bagel extends Item{
    public Bagel(String type, double price){
        super(type, price);

    }
    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

}
