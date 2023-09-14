package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private int capacity;
    private Map<Item, Integer> itemsMap;
   private Inventory inventory;
    // make static and final and exclude from constructor?

    public Basket( Inventory inventory,int capacity ) {
        this.capacity = capacity;
        this.itemsMap = new HashMap<Item,Integer>();
        this.inventory = inventory;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Map<Item, Integer> getItemsMap() {
        return itemsMap;
    }

    public void setItemsMap(Map<Item, Integer> itemsMap) {
        this.itemsMap = itemsMap;
    }
    public boolean addToBasket(Item item, int amount) {
        if (this.inventory.getInventoryList().contains(item)) {
            this.itemsMap.put(item,amount);
            return true;
        }
        return false;
    }
}
