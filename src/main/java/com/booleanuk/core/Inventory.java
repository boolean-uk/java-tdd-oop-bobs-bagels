package com.booleanuk.core;


import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Item> items;

    public Inventory() {
        items = new HashMap<>();
        addItem(new Item("BGLO", 0.49, "Bagel", Bagel.BagelVariant.ONION);
        addItem(new Item("BGLP", 0.39, "Bagel", Item.BagelVariant.PLAIN));
        addItem(new Item("BGLE", 0.49, "Bagel", Item.BagelVariant.EVERYTHING));
        addItem(new Item("BGLS", 0.49, "Bagel", Item.BagelVariant.SESAME));
        addItem(new Item("COFB", 0.99, "Coffee", "Black"));
        addItem(new Item("COFW", 1.19, "Coffee", "White"));
        addItem(new Item("COFC", 1.29, "Coffee", "Capuccino"));
        addItem(new Item("COFL", 1.29, "Coffee", "Latte"));
        addItem(new Item("FILB", 0.12, "Filling", "Bacon"));
        addItem(new Item("FILE", 0.12, "Filling", "Egg"));
        addItem(new Item("FILC", 0.12, "Filling", "Cheese"));
        addItem(new Item("FILX", 0.12, "Filling", "Cream Cheese"));
        addItem(new Item("FILS", 0.12, "Filling", "Smoked Salmon"));
        addItem(new Item("FILH", 0.12, "Filling", "Ham"));
    }

    private void addItem(Item item) {
        items.put(item.getSku(),item);

    }

}

