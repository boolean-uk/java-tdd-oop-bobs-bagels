package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Item> items = new ArrayList<>();

    public boolean addItem(String sku, double price, String name, String variant) {
        items.add(new Item());
        return true;
    }

    public boolean removeItem(String sku) {
        return true;
    }

    public List<Item> getItems() {
        return items;
    }
}
