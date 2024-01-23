package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class StoreInventory {
    private List<Item> items;

    public StoreInventory() {
        this.items = new ArrayList<>();
        initializeInventory();
    }

    private void initializeInventory() {
        // Add predefined items to the inventory
        items.add(new Bagel("Onion", 0.49, "BGLO"));
        items.add(new Bagel("Plain", 0.39, "BGLP"));
        items.add(new Bagel("Everything", 0.49, "BGLE"));
        items.add(new Bagel("Sesame", 0.49, "BGLS"));
        items.add(new Coffee("Black", 0.99, "COFB"));
        items.add(new Coffee("White", 1.19, "COFW"));
        items.add(new Coffee("Cappuccino", 1.29, "COFC"));
        items.add(new Coffee("Latte", 1.29, "COFL"));
        items.add(new Filling("Bacon", 0.12, "FILB"));
        items.add(new Filling("Egg", 0.12, "FILE"));
        items.add(new Filling("Cheese", 0.12, "FILC"));
        items.add(new Filling("Cream Cheese", 0.12, "FILX"));
        items.add(new Filling("Smoked Salmon", 0.12, "FILS"));
        items.add(new Filling("Ham", 0.12, "FILH"));
    }

    public List<Item> getAllItems() {
        return items;
    }

    public Item getItemBySku(String sku) {
        for (Item item : items) {
            if (item.getSku().equals(sku)) {
                return item;
            }
        }
        return null; // Item not found
    }
}
