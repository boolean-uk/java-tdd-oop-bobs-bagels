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

    public Boolean changeCapacity(int newCapacity){
        if (newCapacity >= items.size()) {
            this.capacity = newCapacity;
            return true;
        }
        return false;
    }

    public boolean addItems(Inventory inventory, String sku, int quantity) {
        Item itemToAdd = inventory.getItemBySKU(sku);
        if (itemToAdd == null || items.size() + quantity > capacity) {
            return false;
        }

        for (int i = 0; i < quantity; i++) {
            items.add(itemToAdd);
        }
        return true;
    }
    public boolean removeItems(Inventory inventory, String skuToRemove, int quantityToRemove) {
        Item itemToRemove = inventory.getItemBySKU(skuToRemove);
        if (itemToRemove != null && items.contains(itemToRemove)) {
            return false;
        }
        for (int i = 0; i < quantityToRemove; i++) {
            items.remove(itemToRemove);
        }
        return true;
    }
    public String showBasket() {
        return new ArrayList<>(items).toString();
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (Item item : items) {
            totalCost += item.getTotalCost();
        }
        return totalCost;
    }

}
