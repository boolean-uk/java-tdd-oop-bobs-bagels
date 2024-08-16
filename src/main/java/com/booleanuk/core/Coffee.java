package com.booleanuk.core;

public class Coffee {
    private String sku;
    private double price;
    private String name;
    private String variant;

    Coffee(String sku, double price, String name, String variant){
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;

    }

    //Created getters for Coffee
    public String getName(){
        return this.name;
    }

    public String getVariant(){
        return this.variant;
    }

    public String getSku() {
        return sku;
    }

    public double getPrice(){
        return this.price;
    }

}
