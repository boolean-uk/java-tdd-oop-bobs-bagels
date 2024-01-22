package com.booleanuk.core;

public class Filling implements Product {
    private String sku;
    private String variant;
    private String type;
    private double price;

    public Filling(String Sku, String variant, double price) {
        this.sku = Sku;
        this.variant = variant;
        this.price = price;
        this.type = "Filling";

    }

    public String getSku(){
        return sku;
    }
    public String getVariant(){
        return variant;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
