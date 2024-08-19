package com.booleanuk.core;

public class Product {

    private String sku;
    private String variant;
    private int price;

    public Product(String sku, String variant, int price){
        this.sku = sku;
        this.variant = variant;
        this.price = price;
    }

    public String getString(){
        return this.sku;
    }

    public void setSku(String newSku){
        this.sku = newSku;
    }

    public String getVariant(){
        return this.variant;
    }

    public void setVariant(String newVariant){
        this.variant = newVariant;
    }

    public int getPrice(){
        return this.price;
    }

    public void setPrice(int newPrice){
        this.price = newPrice;
    }
}
