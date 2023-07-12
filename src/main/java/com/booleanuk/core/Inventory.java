package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Inventory {
    private static List<Item> inventory = new ArrayList<>();;

    public static void createInventory(){

        inventory.add(new Bagel("BGLO", "Bagel", 0.49, "Onion"));
        inventory.add(new Bagel("BGLP", "Bagel", 0.39, "Plain"));
        inventory.add(new Bagel("BGLE", "Bagel", 0.49, "Everything"));
        inventory.add(new Bagel("BGLS", "Bagel", 0.49, "Sesame"));

        inventory.add(new Coffee("COFB", "Coffee", 0.99, "Black"));
        inventory.add(new Coffee("COFW", "Coffee", 1.19, "White"));
        inventory.add(new Coffee("COFC", "Coffee", 1.29, "Cappuccino"));
        inventory.add(new Coffee("COFL", "Coffee", 1.29, "Latte"));

        inventory.add(new Filling("FILB", "Filling", 0.12, "Bacon"));
        inventory.add(new Filling("FILE", "Filling", 0.12, "Egg"));
        inventory.add(new Filling("FILC", "Filling", 0.12, "Cheese"));
        inventory.add(new Filling("FILX", "Filling", 0.12, "Cream Cheese"));
        inventory.add(new Filling("FILS", "Filling", 0.12, "Smoked Salmon"));
        inventory.add(new Filling("FILH", "Filling", 0.12, "Ham"));
    }


    public static Optional<Item> searchInventory(String name, String variant){
        for(Item i: inventory){
            if(i.getName().equals(name) && i.getVariant().equals(variant)){
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    public static Optional<Double> getItemPrice(String name, String variant) {
        Optional<Item> optionalItem = searchInventory(name, variant);
        return optionalItem.map(Item::getPrice);
    }
}
