package com.booleanuk.extension.extension;


import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Item> items;

    public Inventory() {
        items = new HashMap<>();
        addItem(new Bagel("BGLO", 0.49, "Bagel", Bagel.BagelVariant.ONION));
        addItem(new Bagel("BGLP", 0.39, "Bagel", Bagel.BagelVariant.PLAIN));
        addItem(new Bagel("BGLE", 0.49, "Bagel", Bagel.BagelVariant.EVERYTHING));
        addItem(new Bagel("BGLS", 0.49, "Bagel", Bagel.BagelVariant.SESAME));
        addItem(new Coffee("COFB", 0.99, "Coffee", "Black"));
        addItem(new Coffee("COFW", 1.19, "Coffee", "White"));
        addItem(new Coffee("COFC", 1.29, "Coffee", "Capuccino"));
        addItem(new Coffee("COFL", 1.29, "Coffee", "Latte"));
        addItem(new Filling("FILB", 0.12, "Filling", "Bacon"));
        addItem(new Filling("FILE", 0.12, "Filling", "Egg"));
        addItem(new Filling("FILC", 0.12, "Filling", "Cheese"));
        addItem(new Filling("FILX", 0.12, "Filling", "Cream Cheese"));
        addItem(new Filling("FILS", 0.12, "Filling", "Smoked Salmon"));
        addItem(new Filling("FILH", 0.12, "Filling", "Ham"));
    }

    private void addItem(Item item) {
        items.put(item.getSku(), item);
    }

    public Item getItem(String sku) {
        return items.get(sku);
    }

    public boolean isItemAvailable(String sku) {
        return items.containsKey(sku);
    }

}

