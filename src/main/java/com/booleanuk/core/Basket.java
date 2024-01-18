package com.booleanuk.core;

import java.util.HashMap;

public class Basket {
    private HashMap<String, Integer> basketMap;
    private Inventory inventory;

    public Basket() {
        this.basketMap = new HashMap<>();
        this.inventory = new Inventory();
    }

    public HashMap<String, Integer> getBasketMap() {
        return basketMap;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public boolean add(String sku) {
        if (this.basketMap.containsKey(sku)) {
            this.basketMap.put(sku, this.basketMap.get(sku)+1);
            return true;
        } else {
            for (Product product : inventory.getProducts()) {
                if (sku.equals(product.getSku())) {
                    this.basketMap.put(sku, 1);
                    return true;
                }
            }
        }
        return false;
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
