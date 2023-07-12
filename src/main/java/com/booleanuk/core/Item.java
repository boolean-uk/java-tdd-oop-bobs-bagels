package com.booleanuk.core;

import java.util.HashMap;
import java.util.HashSet;

public class Item {
    private String sku;
    private double price;
    private String variant;


    public Item(String sku, double price, String variant) {
        this.sku = sku;
        this.price = price;
        this.variant = variant;
    }
    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setVariant(String variant) {
        this.variant = variant;
    }
    public String getVariant() {
        return variant;
    }
}

