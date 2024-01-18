package com.booleanuk.core;

import java.util.HashMap;

public class BobsBagelsShop {
    public HashMap<Item, Integer> inventory;
    public int basketCapacity;

    public BobsBagelsShop(HashMap<Item, Integer> newInventory, int capacity) {
        this.inventory = newInventory;
        this.basketCapacity = capacity;
    }

    public String showInventory() {
        if (this.inventory.isEmpty()) {
            return "No items in stock.";
        }
        StringBuilder output;
        output = new StringBuilder("Bob's Bagels\nSKU\tPrice\tName\tVariant\n");
        for (Item item : inventory.keySet()) {
            String itemString = item.sku+"\t"+item.checkPrice()+"\t"+item.name+"\t"+item.variant+"\n";
            output.append(itemString);
        }
        return output.toString();
    }
}
