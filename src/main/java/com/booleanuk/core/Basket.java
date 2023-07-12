package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
    private List<String> items;
    private Inventory inventory;
    private int capacity;

    public Basket(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
        inventory = new Inventory();
    }

    public List<String> getItems() {
        return items;
    }

    public void addItem(String item) {
        if(inventory.checkAvailability(item) == true)
            items.add(item);
    }
}
