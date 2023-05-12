package com.booleanuk.core;

public class Filling {
    String variant;
    double price;

    public Filling(String variant, double price){
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
