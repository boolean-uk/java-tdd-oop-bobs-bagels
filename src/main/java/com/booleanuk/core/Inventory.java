package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
   private HashMap<String, InventoryItem> inventoryItemHashMap = new HashMap<>();

    public void addInventoryItem( InventoryItem item){
        inventoryItemHashMap.put(item.getSku(), item);
    }


    public HashMap<String, InventoryItem> getInventoryItemHashMap() {
        return inventoryItemHashMap;
    }

    public void setInventoryItemHashMap(HashMap<String, InventoryItem> inventoryItemHashMap) {
        this.inventoryItemHashMap = inventoryItemHashMap;
    }

    public InventoryItem getInventoryItemDetails(String sku){
       return this.inventoryItemHashMap.get(sku);
    }
}
