package com.booleanuk.core;

public class Bagel implements Product {

    String bagel;
    double price;

    public Bagel(String name){
        this.bagel = name;
        this.price = 2.00;
    }
    @Override
    public String getName(){
        return this.bagel;
    }
    @Override
    public double getPrice(){
        return this.price;
    }

}
