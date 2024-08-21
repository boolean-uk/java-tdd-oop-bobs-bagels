package com.booleanuk.core;

import java.util.HashMap;

public class Store {
    private int capacity = 20;
    private HashMap<String, Product> inventory = new HashMap<>();

    public void addToInventory(Product product) {
        int maxSizeInventory = 15;
        if (inventory.size() < maxSizeInventory) {
            inventory.put(product.getSKU(), product);
        } else System.out.println("Inventory should not be able to consist of more then 15 items");

    }

    public void updateCapacity(int capacity) {
        this.capacity += capacity;

    }

    public int getCapacity() {
        return capacity;
    }

    public boolean findProductInInventory(String SKU) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.containsKey(SKU)) {
                return true;
            }

        }
        return false;
    }

    public Product getProductBySKU(String SKU) {
        return inventory.get(SKU);
    }
}


