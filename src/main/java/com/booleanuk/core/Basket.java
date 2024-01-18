package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private int capacity;
    private ArrayList<Item> items;
    private int quantity;

    public Basket(int capacity){
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public Boolean addItems(Item item){
        if (items.size() + quantity <= capacity) {
            for (int i = 0; i < quantity; i++) {
                items.add(item);
            }
            return true;
        }
        return false;
    }
    public boolean removeItems(Item item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            if (!items.remove(item)) {
                // If the item is not found, return false
                return false;
            }
        }
        return true;
    }
    public double getTotalCost() {
        double totalCost = 0;
        for (Item item : items) {
            totalCost += item.getTotalCost();
        }
        return totalCost;
    }
}
