package com.booleanuk.core;

import java.util.HashMap;

public class BobsBagelsShop {
    private HashMap<Item, Integer> inventory;

    public BobsBagelsShop(HashMap<Item, Integer> newInventory) {
        this.inventory = newInventory;
    }

    public String showInventory() {
        if (this.inventory.isEmpty()) {
            return "No items in stock.";
        }
        StringBuilder output;
        output = new StringBuilder("Bob's Bagels\nSKU\tPrice\tName\tVariant\n");
        for (Item item : inventory.keySet()) {
            String itemString = item.getSku()+"\t"+item.getPrice()+"\t"+item.getName()+"\t"+item.getVariant()+"\n";
            output.append(itemString);
        }
        return output.toString();
    }

    public HashMap<Item, Integer> getInventory() {
        return this.inventory;
    }

    public void setInventory(HashMap<Item, Integer> newInventory) {
        this.inventory = newInventory;
    }
}
