package com.booleanuk.core;

import java.util.ArrayList;
public class Inventory {

    private ArrayList<InventoryItem> inventoryItem;

    Inventory() {
        this.inventoryItem = new ArrayList<>();

        this.inventoryItem.add(new InventoryItem("BGLO", 0.49, "Bagel", "Onion"));
        this.inventoryItem.add(new InventoryItem("BGLP", 0.39, "Bagel", "Plain"));
        this.inventoryItem.add(new InventoryItem("BGLE", 0.49, "Bagel", "Everything"));
        this.inventoryItem.add(new InventoryItem("BGLS", 0.49, "Bagel", "Sesame"));
        this.inventoryItem.add(new InventoryItem("COFB", 0.99, "Coffee", "Black"));
        this.inventoryItem.add(new InventoryItem("COFW", 1.19, "Coffee", "White"));
        this.inventoryItem.add(new InventoryItem("COFC", 1.29, "Coffee", "Cappuccino"));
        this.inventoryItem.add(new InventoryItem("COFL", 1.29, "Coffee", "Latte"));
        this.inventoryItem.add(new InventoryItem("FILB", 0.12, "Filling", "Bacon"));
        this.inventoryItem.add(new InventoryItem("FILE", 0.12, "Filling", "Egg"));
        this.inventoryItem.add(new InventoryItem("FILC", 0.12, "Filling", "Cheese"));
        this.inventoryItem.add(new InventoryItem("FILX", 0.12, "Filling", "Cream Cheese"));
        this.inventoryItem.add(new InventoryItem("FILS", 0.12, "Filling", "Smoked Salmon"));
        this.inventoryItem.add(new InventoryItem("FILH", 0.12, "Filling", "Ham"));
    }

    public ArrayList<InventoryItem> getInventoryItem() {
        return inventoryItem;
    }

}