package com.booleanuk.core;

import java.util.HashMap;

public class Inventory extends Basket {

    HashMap<String, Double> inventoryPriceList;

    public HashMap<String, Double> makeInventoryPriceList(){
        this.inventoryPriceList = new HashMap<>();
        inventoryPriceList.put("BGLO", 0.49);
        inventoryPriceList.put("BGLP", 0.39);
        inventoryPriceList.put("BGLE", 0.49);
        inventoryPriceList.put("BGLS", 0.49);

        inventoryPriceList.put("COFB", 0.99);
        inventoryPriceList.put("COFW", 1.19);
        inventoryPriceList.put("COFC", 1.29);
        inventoryPriceList.put("COFL", 1.29);

        inventoryPriceList.put("FILB", 0.12);
        inventoryPriceList.put("FILE", 0.12);
        inventoryPriceList.put("FILC", 0.12);
        inventoryPriceList.put("FILX", 0.12);
        inventoryPriceList.put("FILS", 0.12);
        inventoryPriceList.put("FILH", 0.12);


        return inventoryPriceList;
    }

}
