package com.booleanuk.core;

import java.util.HashMap;

public class Inventory {
    HashMap<String,Foods> inventoryList;

    public Inventory(){
        initialize();
    }
    private void initialize() {
        this.inventoryList = new HashMap<>();
        Bagel bagel1 = new Bagel("BGLO",0.49d,"Onion");
        Bagel bagel2 = new Bagel("BGLP",0.39d,"Plain");
        Bagel bagel3 = new Bagel("BGLE",0.49d,"Everything");
        Bagel bagel4 = new Bagel("BGLS",0.49d,"Sesame");
        inventoryList.put(bagel1.getSku(),bagel1);
        inventoryList.put(bagel2.getSku(),bagel2);
        inventoryList.put(bagel3.getSku(),bagel3);
        inventoryList.put(bagel4.getSku(),bagel4);
    }

    public Foods get(String sku) {
        for (Foods food: inventoryList.values()) {
            if (food.getSku().equals(sku)) {
                return food;
            }
        }
        return null;
    }
}
