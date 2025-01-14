package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private HashMap<String, Item> inventoryItems;

    public Inventory(HashMap<String, Item> inventoryItems) {
        this.inventoryItems = new HashMap<>();
        this.inventoryItems.put("BGLO", new Item("BGLO", 0.49, "Bagel", "Onion"));
        this.inventoryItems.put("BGLP", new Item("BGLP", 0.39, "Bagel", "Plain"));
        this.inventoryItems.put("BGLE", new Item("BGLE", 0.49, "Bagel", "Everything"));
        this.inventoryItems.put("BGLS", new Item("BGLS", 0.49, "Bagel", "Sesame"));
        this.inventoryItems.put("COFB", new Item("COFB", 0.99, "Coffee", "Black"));
        this.inventoryItems.put("COFW", new Item("COFW", 1.19, "Coffee", "White"));
        this.inventoryItems.put("COFC", new Item("COFC", 1.29, "Coffee", "Capuccino"));
        this.inventoryItems.put("COFL", new Item("COFL", 1.29, "Coffee", "Latte"));
        this.inventoryItems.put("FILB", new Item("FILB", 0.12, "Filling", "Bacon"));
        this.inventoryItems.put("FILE", new Item("FILE", 0.12, "Filling", "Egg"));
        this.inventoryItems.put("FILC", new Item("FILC", 0.12, "Filling", "Cheese"));
        this.inventoryItems.put("FILX", new Item("FILX", 0.12, "Filling", "Cream Cheese"));
        this.inventoryItems.put("FILS", new Item("FILS", 0.12, "Filling", "Smoked Salmon"));
        this.inventoryItems.put("FILH", new Item("FILH", 0.12, "Filling", "Ham"));
    }

    public boolean hasItem(String item) {
        System.out.println(item);
        System.out.println(inventoryItems);
        return inventoryItems.containsKey(item);
    }
}

