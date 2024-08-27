package com.booleanuk.core;

public class InventoryItem {
    private String sku;
    private double price;
    private String name;
    private String variant;

    public InventoryItem(String sku, double price, String name, String variant){
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;

    }

    public double getPrice() {
        return price;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public String getVariant() {
        return variant;
    }


}
