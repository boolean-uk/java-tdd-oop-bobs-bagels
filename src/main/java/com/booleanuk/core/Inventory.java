package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    public Map<String, Item> items = new HashMap<>();

    public Inventory() {
        
        items.put("BGLO", new Bagel("BGLO", 0.49, "item", "Onion"));
        items.put("BGLP", new Bagel("BGLP", 0.39, "Bagel", "Plain"));
        items.put("BGLE", new Bagel("BGLE", 0.49, "Bagel", "Everything"));
        items.put("BGLS", new Bagel("BGLS", 0.49, "Bagel", "Sesame"));
        items.put("COFB", new Coffee("COFB", 0.99, "Coffee", "Black"));
        items.put("COFW", new Coffee("COFW", 1.19, "Coffee", "White"));
        items.put("COFC", new Coffee("COFC", 1.29, "Coffee", "Cappuccino"));
        items.put("COFL", new Coffee("COFL", 1.29, "Coffee", "Latte"));
        items.put("FILB", new Filling("FILB", 0.12, "Filling", "Bacon"));
        items.put("FILE", new Filling("FILE", 0.12, "Filling", "Egg"));
        items.put("FILC", new Filling("FILC", 0.12, "Filling", "Cheese"));
        items.put("FILX", new Filling("FILX", 0.12, "Filling", "Cream Cheese"));
        items.put("FILS", new Filling("FILS", 0.12, "Filling", "Smoked Salmon"));
        items.put("FILH", new Filling("FILH", 0.12, "Filling", "Ham"));
        
    }

    public Item getItem(String sku) {
        return items.get(sku);
    }
}
