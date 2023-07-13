package com.booleanuk.core;

public class Coffee {
    private String SKU;
    private double price;
    private String variant;

    public Coffee(String SKU, double price, String variant){
        this.SKU= SKU;
        this.price=price;
        this.variant=variant;


    }
    public String getSKU(){
        return SKU;
    }
    public double getPrice(){
        return price;
    }
    public String getVariant(){
        return variant;
    }
}
