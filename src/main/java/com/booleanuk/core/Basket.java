package com.booleanuk.core;

import java.util.HashMap;

public class Basket {
    HashMap<String, Integer> basketMap;
    Inventory inventory;

    public Basket() {
        this.basketMap = new HashMap<>();
        this.inventory = new Inventory();
    }

    public boolean add(String sku) {
        if (this.basketMap.containsKey(sku)) {
            this.basketMap.put(sku, this.basketMap.get(sku)+1);
            return true;
        } else {
            for (Product product : inventory.products) {
                if (sku.equals(product.sku)) {
                    this.basketMap.put(sku, 1);
                    return true;
                }
            }
        }
        return false;
    }
}
