package com.booleanuk.core;

import java.util.ArrayList;
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
    HashMap<String, Item> listItems = new HashMap<>();
    public Item getItem (String sku) {
        listItems.put("BGLO", onionBagel);
        listItems.put("BGLP", plainBagel);
        listItems.put("BGLE", everythingBagel);
        listItems.put("BGLS", sesameBagel);
        listItems.put("COFB", blackCoffee);
        listItems.put("COFW", whiteCoffee);
        listItems.put("COFC", cappuccinoCoffee);
        listItems.put("COFL", latteCoffee);
        listItems.put("FILB", baconFilling);
        listItems.put("FILE", eggFilling);
        listItems.put("FILC", cheeseFilling);
        listItems.put("FILX", creamCheeseFilling);
        listItems.put("FILS", smokedSalmonFilling);
        listItems.put("FILH", hamFilling);

        if(listItems.containsKey(sku)) {
            return listItems.get(sku);
        }
        System.out.println("This item does not exist");
        return null;
    }

}
