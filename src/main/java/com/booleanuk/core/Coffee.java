package com.booleanuk.core;

public class Coffee implements Product {
    private String sku;
    private String variant;
    private String type;
    private double price;

    public Coffee(String Sku, String variant, double price) {
        this.sku = Sku;
        this.variant = variant;
        this.price = price;
        this.type = "Coffee";

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
