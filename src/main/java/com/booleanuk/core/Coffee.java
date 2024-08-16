package com.booleanuk.core;

public class Coffee {
    private String sku;
    private int price;
    private String name;
    private String variant;

    Coffee(String sku, int price, String name, String variant){
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

    public int getPrice(){
        return this.price;
    }




}
