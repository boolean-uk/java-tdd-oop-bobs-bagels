package com.booleanuk.core;

import java.util.HashMap;
import java.util.HashSet;

public class Item {
    private final String sku;
    private double price;
    private final String variant;
    public Item(String sku, double price, String variant) {
        this.sku = sku;
        this.price = price;
        this.variant = variant;
    }
    public String getSku() {
        return sku;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getVariant() {
        return variant;
    }
}

