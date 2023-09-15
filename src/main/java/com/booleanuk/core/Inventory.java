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
        Filling filling1 = new Filling("FILB",0.12d,"Bacon");
        Filling filling2 = new Filling("FILE",0.12d,"Egg");
        Filling filling3 = new Filling("FILC",0.12d,"Cheese");
        Filling filling4 = new Filling("FILX",0.12d,"Cream Cheese");
        Filling filling5 = new Filling("FILS",0.12d,"Smoked Salmon");
        Filling filling6 = new Filling("FILH",0.12d,"Ham");
        inventoryList.put(bagel1.getSku(),bagel1);
        inventoryList.put(bagel2.getSku(),bagel2);
        inventoryList.put(bagel3.getSku(),bagel3);
        inventoryList.put(bagel4.getSku(),bagel4);
        inventoryList.put(filling1.getSku(),filling1);
        inventoryList.put(filling2.getSku(),filling2);
        inventoryList.put(filling3.getSku(),filling3);
        inventoryList.put(filling4.getSku(),filling4);
        inventoryList.put(filling5.getSku(),filling5);
        inventoryList.put(filling6.getSku(),filling6);
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
