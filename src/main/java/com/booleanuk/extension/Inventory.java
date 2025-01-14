package com.booleanuk.extension;

import java.util.HashMap;

public class Inventory {
    private HashMap<SKU, Integer> invMap = new HashMap<>();   

    boolean checkStock(SKU sku) {
        if (invMap.containsKey(sku) && invMap.get(sku) > 0) {
            return true;
        }
        return false;
    }

    boolean addStock(SKU sku, int amount) {
        if (amount <= 0) {
            return false;
        }
        // if sku already in stock
        if(invMap.containsKey(sku)) {
           invMap.put(sku, invMap.get(sku) + amount);
        }
        // if sku not in stock 
        else {
            invMap.put(sku, amount);
        }
        return true;
    }

    boolean removeStock(SKU sku, int amount) {
        // if amount is more than in stock return false
        if (!checkStock(sku) || amount > invMap.get(sku)) {
            return false;
        }

        invMap.put(sku, invMap.get(sku) - amount);
        return true;
    }

}
