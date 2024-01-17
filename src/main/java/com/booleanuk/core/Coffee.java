package com.booleanuk.core;

public class Coffee implements Product{
    String name;
    String flavor;
    double price;


    public Coffee(String flavor){
        this.flavor = flavor;
        this.name = flavor + " coffee";
        this.price = 1.00;
    }

    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public double getPrice(){
        return this.price;
    }
    public String getFlavor(){
        return this.flavor;
    }

}
