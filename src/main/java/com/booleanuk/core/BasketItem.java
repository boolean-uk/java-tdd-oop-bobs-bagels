package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class BasketItem {
    private String type;
    private int quantity;
    private double price;
    private String sku;
    private Map<String, Integer> addOns;

    public BasketItem(String sku, String type, double price, int quantity){
        this.sku = sku;
        this.type = type;
        this.price = price;
        this.quantity = quantity;

    }

    public BasketItem(String sku, String type, double price, int quantity, Map<String, Integer> addOns){
        this.sku = sku;
        this.type = type;
        this.price = price;
        this.quantity = quantity;

    }

    public String getType() {
        return type;
    }
    public double getPrice() {
        return price;
    }

    public Map<String, Integer> getAddOns() {
        return addOns;
    }

    public String getSku() {
        return sku;
    }

    public int getQuantity() {
        return quantity;
    }
}
