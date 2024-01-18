package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    public ArrayList<Product> inventory;

    public Inventory() {
        this.inventory = new ArrayList<>();
        initializeInventory();
    }

    private void initializeInventory() {
        inventory.add( new Bagel("BGLO", 0.49, "Onion"));
        inventory.add( new Bagel("BGLP", 0.39, "Plain"));
        inventory.add( new Bagel("BGLE", 0.49, "Everything"));
        inventory.add( new Bagel("BGLS", 0.49, "Sesame"));
        inventory.add( new Coffee("COFB", 0.99, "Black"));
        inventory.add( new Coffee("COFW", 1.19, "White"));
        inventory.add( new Coffee("COFC", 1.29, "Capuccino"));
        inventory.add( new Coffee("COFL", 1.29, "Latte"));
        inventory.add( new Filling("FILB", 0.12, "Bacon"));
        inventory.add( new Filling("FILE", 0.12, "Egg"));
        inventory.add( new Filling("FILC", 0.12, "Cheese"));
        inventory.add( new Filling("FILX", 0.12, "Cream Cheese"));
        inventory.add( new Filling("FILS", 0.12, "Smoked Salmon"));
        inventory.add(new Filling("FILH", 0.12, "Ham"));
    }

    public Product getProduct(String variant) {
        for (Product product : inventory) {
            if (product.getVariant().equalsIgnoreCase(variant)) {
                return product;
            }
        }
        return null; // Product not found
    }

}
