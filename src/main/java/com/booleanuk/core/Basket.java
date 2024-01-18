package com.booleanuk.core;

import java.util.ArrayList;

import static java.lang.Math.round;

public class Basket {
    private ArrayList<String> basket;
    private int capacity;
    private double total;

    Inventory inventory;

    public Basket() {
        inventory = new Inventory();

        this.basket = new ArrayList<>();
        this.capacity = 30;
        this.total = 0.0;
    }

    public String getBasketItemAtIndex(int index) {
        return this.basket.get(index);
    }

    public int getBasketSize() {
        return this.basket.size();
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
        this.basket.add(sku);
        String strPrice = this.inventory.inventory.get(sku)[1];
        double price = Double.parseDouble(strPrice);
        this.total += price;
        this.total = Math.round(this.total*100.0) / 100.0;
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

    public double getTotal() {
        return this.total;
    }

    public String getPrice(String item) {
        String sku = this.inventory.mapTypeVariantToSKU.get(item);
        return this.inventory.inventory.get(sku)[1];
    }

}
