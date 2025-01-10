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
            inventory.removeStock(item.getSku(), 1); // remove item from stock
            return true;
        }
        return false;
    }

    boolean removeItem(SKU sku) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getSku() == sku) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    float getTotalCost() {
        float total = 0f;
        for (Item i : items) {
            total += i.getPrice();
        }
        return total;
    }

    ArrayList<Item> getItems() {
        return items;
    }
}
