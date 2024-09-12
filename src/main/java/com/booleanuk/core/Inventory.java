package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private static Inventory singleton = null;
    private static List<InventoryItem> inventoryItemList = new ArrayList<>();

    private Inventory(){
        inventoryItemList.add(new Bagel("BGLO",49,"Onion"));
        inventoryItemList.add(new Bagel("BGLP",39,"Plain"));
        inventoryItemList.add(new Bagel("BGLE",49,"Everything"));
        inventoryItemList.add(new Bagel("BGLS",49,"Sesame"));
        inventoryItemList.add(new Coffee("COFB",99,"Black"));
        inventoryItemList.add(new Coffee("COFW",19,"White"));
        inventoryItemList.add(new Coffee("COFC",29,"Capuccino"));
        inventoryItemList.add(new Coffee("COFL",29,"Latte"));
        inventoryItemList.add(new Filling("FILB","Bacon"));
        inventoryItemList.add(new Filling("FILE","Egg"));
        inventoryItemList.add(new Filling("FILC","Cheese"));
        inventoryItemList.add(new Filling("FILX","Cream Cheese"));
        inventoryItemList.add(new Filling("FILS","Smoked Salmon"));
        inventoryItemList.add(new Filling("FILH","Ham"));
    }

    public static Inventory getInstance(){
        if (singleton == null)
            singleton = new Inventory();

        return singleton;
    }

    public static List<InventoryItem> getList(){
        return inventoryItemList;
    }

    public static InventoryItem getItemByIndex(int i){
        return inventoryItemList.get(i);
    }

    public String getAllItems(){
        String allItems = "";
        for (int i = 0; i < inventoryItemList.size(); i++) {
            allItems += "" + i + ". " + inventoryItemList.get(i).toString();
        }
        return allItems;
    }
}
