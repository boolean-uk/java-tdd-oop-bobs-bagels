package com.booleanuk.core;

import java.util.HashMap;

public class Inventory {
    Item onionBagel = new Item("Bagel", 0.49, "BGLO", "Onion");
    Item plainBagel = new Item("Bagel", 0.39, "BGLP", "Plain");
    Item everythingBagel = new Item("Bagel", 0.49, "BGLE", "Everything");
    Item sesameBagel = new Item("Bagel", 0.49, "BGLS", "Sesame");
    Item blackCoffee = new Item("Coffee", 0.99, "COFB", "Black");
    Item whiteCoffee = new Item("Coffee", 1.19, "COFW", "White");
    Item cappuccinoCoffee = new Item("Coffee", 1.29, "COFC", "Cappuccino");
    Item latteCoffee = new Item("Coffee", 1.29, "COFL", "Latte");
    Item baconFilling = new Item("Filling", 0.12, "FILB", "Bacon");
    Item eggFilling = new Item("Filling", 0.12, "FILE", "Egg");
    Item cheeseFilling = new Item("Filling", 0.12, "FILC", "Cheese");
    Item creamCheeseFilling = new Item("Filling", 0.12, "FILX", "Cream Cheese");
    Item smokedSalmonFilling = new Item("Filling", 0.12, "FILS", "Smoked Salmon");
    Item hamFilling = new Item("Filling", 0.12, "FILH", "Ham");
    HashMap<String, Item> allItems = new HashMap<>();
    public Item getItem (String sku) {
        allItems.put("BGLO", onionBagel);
        allItems.put("BGLP", plainBagel);
        allItems.put("BGLE", everythingBagel);
        allItems.put("BGLS", sesameBagel);
        allItems.put("COFB", blackCoffee);
        allItems.put("COFW", whiteCoffee);
        allItems.put("COFC", cappuccinoCoffee);
        allItems.put("COFL", latteCoffee);
        allItems.put("FILB", baconFilling);
        allItems.put("FILE", eggFilling);
        allItems.put("FILC", cheeseFilling);
        allItems.put("FILX", creamCheeseFilling);
        allItems.put("FILS", smokedSalmonFilling);
        allItems.put("FILH", hamFilling);

        if(allItems.containsKey(sku)) {
            return allItems.get(sku);
        }
        System.out.println("This item does not exist");
        return null;
    }

}
