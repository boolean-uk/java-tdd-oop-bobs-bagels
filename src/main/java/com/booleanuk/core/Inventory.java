package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
   private HashMap<String, InventoryItem> inventoryItemHashMap = new HashMap<>();

   public Inventory () {
       InventoryItem item;

       item = new InventoryItem("BGLO", 0.49, "Bagel", "Onion");
       this.inventoryItemHashMap.put(item.getSku(), item);

       item = new InventoryItem("BGLP", 0.39, "Bagel", "Plain");
       this.inventoryItemHashMap.put(item.getSku(), item);

       item = new InventoryItem("BGLE", 0.49, "Bagel", "Everything");
       this.inventoryItemHashMap.put(item.getSku(), item);

       item = new InventoryItem("BGLS", 0.49, "Bagel", "Sesame");
       this.inventoryItemHashMap.put(item.getSku(), item);

       item = new InventoryItem("COFB", 0.99, "Coffee", "Black");
       this.inventoryItemHashMap.put(item.getSku(), item);

       item = new InventoryItem("COFW", 1.19, "Coffee", "White");
       this.inventoryItemHashMap.put(item.getSku(), item);

       item = new InventoryItem("COFC", 1.29, "Coffee", "Cappuccino");
       this.inventoryItemHashMap.put(item.getSku(), item);

       item = new InventoryItem("COFL", 1.29, "Coffee", "Latte");
       this.inventoryItemHashMap.put(item.getSku(), item);

       item = new InventoryItem("FILB", 0.12, "Filling", "Bacon");
       this.inventoryItemHashMap.put(item.getSku(), item);

       item = new InventoryItem("FILE", 0.12, "Filling", "Egg");
       this.inventoryItemHashMap.put(item.getSku(), item);

       item = new InventoryItem("FILC", 0.12, "Filling", "Cheese");
       this.inventoryItemHashMap.put(item.getSku(), item);

       item = new InventoryItem("FILX", 0.12, "Filling", "Cream Cheese");
       this.inventoryItemHashMap.put(item.getSku(), item);

       item = new InventoryItem("FILS", 0.12, "Filling", "Smoked Salmon");
       this.inventoryItemHashMap.put(item.getSku(), item);

       item = new InventoryItem("FILH", 0.12, "Filling", "Ham");
       this.inventoryItemHashMap.put(item.getSku(), item);
   }



    public void addInventoryItem( InventoryItem item){
        inventoryItemHashMap.put(item.getSku(), item);
    }


    public HashMap<String, InventoryItem> getInventoryItemHashMap() {
        return inventoryItemHashMap;
    }


    public InventoryItem getInventoryItemDetails(String sku){
       return this.inventoryItemHashMap.get(sku);
    }
}
