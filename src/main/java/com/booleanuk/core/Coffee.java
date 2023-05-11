package com.booleanuk.core;

public class Coffee {

    String type;
    double price;

    public Coffee(String type, double price){
        this.type = type;
        this.price = price;
    }

    public String getType(){
        return this.type;
    }

    public double getPrice(){
        return this.price;
    }
}
