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

    public boolean addItem(String item) {
        if(inventory.checkAvailability(item) == true && items.size()<capacity) {
            items.add(item);
            return true;
        }else {
            return false;
        }

    }

    public boolean removeItem(String item) {
        if(items.contains(item)) {
            items.remove(item);
            return true;
        }else {
            return false;
        }
    }

    public void changeCapacity(int newCapacity) {
        this.capacity = newCapacity;
    }



}
