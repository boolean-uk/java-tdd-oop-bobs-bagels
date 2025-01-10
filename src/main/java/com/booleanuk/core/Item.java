package com.booleanuk.core;

public class Item {
    private String sku;
    private String name;
    private String variant;
    private float price;

    public Item(String sku, String name, String variant, float price){
        this.sku = sku;
        this.name = name;
        this.variant = variant;
        this.price = price;
    }

    public String getSku() {return sku;}

    public String getName() {return name;}

    public String getVariant() {return variant;}

    public float getPrice() {return price;}
}
