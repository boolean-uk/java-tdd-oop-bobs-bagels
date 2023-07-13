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
        if(newCapacity > 0 && newCapacity >= items.size()) {
            this.capacity = newCapacity;
        }else if(newCapacity < items.size()) {
            System.out.println("You already got " + items.size() + " bagles in basket so you can't downsize basket to " + newCapacity + " spaces.");
            System.out.println("New basket size is " + items.size());
            this.capacity = items.size();
        }

    }

    public double getTotalPrice() {
        return 0.0;
    }

}
