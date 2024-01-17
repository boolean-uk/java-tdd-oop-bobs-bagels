package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private Map<String, Item> inventory;

    public InventoryManager() {

    }

    public HashMap<String, Item> initializeInventory() {
        return null;
    }

    public String costEachFilling() {
        return "";
    }

    /**
     * Getters for member variables
     */

    public Map<String, Item> getInventory() {
        return inventory;
    }

    /**
     * Setters for member variables
     */

    public void setInventory(Map<String, Item> inventory) {
        this.inventory = inventory;
    }
}
