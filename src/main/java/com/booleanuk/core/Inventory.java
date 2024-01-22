package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    public Map<String, Item> items = new HashMap<>();

    public Inventory() {
        
        items.put("BGLO", new Item("BGLO", 0.49, "item", "Onion"));
        items.put("BGLP", new Item("BGLP", 0.39, "Bagel", "Plain"));
        items.put("BGLE", new Item("BGLE", 0.49, "Bagel", "Everything"));
        items.put("BGLS", new Item("BGLS", 0.49, "Bagel", "Sesame"));
        items.put("COFB", new Item("COFB", 0.99, "Coffee", "Black"));
        items.put("COFW", new Item("COFW", 1.19, "Coffee", "White"));
        items.put("COFC", new Item("COFC", 1.29, "Coffee", "Cappuccino"));
        items.put("COFL", new Item("COFL", 1.29, "Coffee", "Latte"));
        items.put("FILB", new Item("FILB", 0.12, "Filling", "Bacon"));
        items.put("FILE", new Item("FILE", 0.12, "Filling", "Egg"));
        items.put("FILC", new Item("FILC", 0.12, "Filling", "Cheese"));
        items.put("FILX", new Item("FILX", 0.12, "Filling", "Cream Cheese"));
        items.put("FILS", new Item("FILS", 0.12, "Filling", "Smoked Salmon"));
        items.put("FILH", new Item("FILH", 0.12, "Filling", "Ham"));
        
    }

    public Item getItem(String sku) {
        return items.get(sku);
    }
}
