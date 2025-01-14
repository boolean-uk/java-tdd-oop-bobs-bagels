package com.booleanuk.core;

import java.util.HashMap;

public class Basket {
    protected HashMap<String, Double> items;

    public Basket(HashMap<String, Double> items) {
        this.items = items;
    }

    public boolean addItem(String item, double price) {
        if (!items.containsKey(item)) {
            items.put(item, price);
            return true;
        }
        return false;
    }
}
