package com.booleanuk.core;

import java.util.HashMap;

public class BasketItem {
    private String type;
    private double price;
    private HashMap<String, Integer> addOns = new HashMap<>();

    public BasketItem(String type, double price){
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }
    public double getPrice() {
        return price;
    }
}
