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
        return "";
    }
}
