package com.booleanuk.core;

import java.util.Map;

public class Basket {
    private int capacity;
    private Map<Item, Integer> itemsMap;
    Inventory inventory;
    // make static and final and exclude from constructor?

    public Basket(int capacity, Map<Item, Integer> itemsMap, Inventory inventory) {
        this.capacity = capacity;
        this.itemsMap = itemsMap;
        this.inventory = inventory;
    }
}
