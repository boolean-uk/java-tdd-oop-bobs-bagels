package com.booleanuk.core;

public class Coffee {

    String variant;
    double price;

    public Coffee(String variant, double price){
        this.variant = variant;
        this.price = price;
    }

    public String getVariant(){
        return this.variant;
    }

    public double getPrice(){
        return this.price;
    }
}
