package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<InventoryItem> inventoryItem;


    protected Inventory() {
        this.inventoryItem = new ArrayList<>();

        //Bagels
        this.inventoryItem.add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        this.inventoryItem.add(new Bagel("BGLP", 0.39, "Bagel", "Plain"));
        this.inventoryItem.add(new Bagel("BGLE", 0.49, "Bagel", "Everything"));
        this.inventoryItem.add(new Bagel("BGLS", 0.49, "Bagel", "Sesame"));

        //Coffee
        this.inventoryItem.add(new Coffee("COFB", 0.99, "Coffee", "Black"));
        this.inventoryItem.add(new Coffee("COFW", 1.19, "Coffee", "White"));
        this.inventoryItem.add(new Coffee("COFC", 1.29, "Coffee", "Cappuccino"));
        this.inventoryItem.add(new Coffee("COFL", 1.29, "Coffee", "Latte"));

        //BagelFillings
        this.inventoryItem.add(new BagelFilling("FILB", 0.12, "Filling", "Bacon"));
        this.inventoryItem.add(new BagelFilling("FILE", 0.12, "Filling", "Egg"));
        this.inventoryItem.add(new BagelFilling("FILC", 0.12, "Filling", "Cheese"));
        this.inventoryItem.add(new BagelFilling("FILX", 0.12, "Filling", "Cream Cheese"));
        this.inventoryItem.add(new BagelFilling("FILS", 0.12, "Filling", "Smoked Salmon"));
        this.inventoryItem.add(new BagelFilling("FILH", 0.12, "Filling", "Ham"));
    }

    public List<InventoryItem> getInventoryItem() {
        return inventoryItem;
    }

}