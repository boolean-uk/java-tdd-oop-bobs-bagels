package com.booleanuk.core;

public abstract class Product {

    private String sku;
    private double price;
    private String name;
    private String variant;

    Product(String sku, double price, String name, String variant){
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }

    public String getSku(){
        return this.sku;
    }

    public double getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    public String getVariant(){
        return this.variant;
    }

    public abstract String showProduct();

    public abstract Product addProduct();

}
