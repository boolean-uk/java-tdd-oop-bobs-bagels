package com.booleanuk.core;

import java.util.Collections;
import java.util.HashMap;

public class Basket {
    private HashMap<String, Integer> basketMap;
    private Inventory inventory;
    private int capacity;

    public Basket() {
        this.basketMap = new HashMap<>();
        this.inventory = new Inventory();
        this.capacity = 5;
    }

    public HashMap<String, Integer> getBasketMap() {
        return basketMap;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String add(String sku) {
        if (this.basketMap.values().stream()
                .mapToInt(Integer::valueOf)
                .sum() >= this.capacity) {
            return "Basket is full";
        }
        if (this.basketMap.containsKey(sku)) {
            this.basketMap.put(sku, this.basketMap.get(sku)+1);
            return "Product added to basket";
        } else {
            for (Product product : inventory.getProducts()) {
                if (sku.equals(product.getSku())) {
                    this.basketMap.put(sku, 1);
                    return "Product added to basket";
                }
            }
        }
        return "Product not found";
    }

    public boolean remove(String sku) {
        if (this.basketMap.containsKey(sku)) {
            if (this.basketMap.get(sku) == 1) {
                this.basketMap.remove(sku);
            } else {
                this.basketMap.put(sku, this.basketMap.get(sku)-1);
            }
            return true;
        }
        return false;
    }
}
