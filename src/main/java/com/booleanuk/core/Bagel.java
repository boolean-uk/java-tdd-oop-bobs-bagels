package com.booleanuk.core;

public class Bagel {

    String bagel;
    double price;

    public Bagel(String name){
        this.bagel = name;
        this.price = 2.00;
    }

    public String getName(){
        return this.bagel;
    }

    public double getPrice(){
        return this.price;
    }

}
