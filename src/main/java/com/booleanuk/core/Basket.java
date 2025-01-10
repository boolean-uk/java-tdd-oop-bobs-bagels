package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private Inventory inventory;
    private int capacity;
    private ArrayList<Item> items;

    public Basket(Inventory inventory, int capacity) {
        this.inventory = inventory;
        this.capacity = capacity;
    }

    boolean addItem(Item item) {
        // if basket is not full and item is in stock
        if (items.size() < capacity && inventory.checkStock(item.getSku())) {
            items.add(item);
            return true;
        }
        return false;
    }
}
