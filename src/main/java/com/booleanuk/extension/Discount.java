package com.booleanuk.extension;

import com.booleanuk.core.Inventory;

import java.util.HashMap;

public class Discount {
    private String sku;
    private double price;

    public Discount(String sku, double price) {
        this.sku = sku;
        this.price = price;
    }

    public double calculateDiscount(String sku, HashMap<String, Integer> map, Inventory inventory) {
        return (double) Math.round(((double) map.get(sku) * (inventory.getProductCost(sku) - this.getPrice())) * 100) /100;
    }

    public String getSku() {
        return sku;
    }
    public double getPrice() {
        return price;
    }
}
