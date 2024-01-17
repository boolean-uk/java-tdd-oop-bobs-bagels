package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    ArrayList<String> basket;
    int capacity;
    Double total;

    Inventory inventory;

    public Basket() {
        inventory = new Inventory();

        this.basket = new ArrayList<>();
        this.capacity = 30;
        this.total = 0.0;
    }

    public boolean addItem(String item) {
        // Basket is full
        if (this.basket.size() >= this.capacity)
            return false;

        // The item is not in the inventory
        if (!this.inventory.mapTypeVariantToSKU.containsKey(item))
            return false;

        // Add item by SKU code to
        String sku = inventory.mapTypeVariantToSKU.get(item);
        basket.add(sku);
        total += Double.parseDouble(inventory.inventory.get(sku)[1]);
        return true;
    }

    public boolean removeItem(String item) {
        String sku = inventory.mapTypeVariantToSKU.get(item);
        // Iterate through basket and remove first and only first instance of the item if the item in
        // in the basket.
        for (int i = 0; i < basket.size(); i++) {
            if (basket.get(i).equals(sku)) {
                this.basket.remove(sku);
                total -= Double.parseDouble(inventory.inventory.get(sku)[1]);
                return true;
            }
        }
        return false;
    }

    public int changeCapacity(int newCapacity) {
        this.capacity = newCapacity;
        return this.capacity;
    }

}
