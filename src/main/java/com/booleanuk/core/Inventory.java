package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private static Inventory singleton = null;
    private static List<InventoryItem> inventoryItemList = new ArrayList<>();

    private Inventory(){
        inventoryItemList.add(new Bagel("BGLO",49,"Bagel","Onion"));
        inventoryItemList.add(new Bagel("BGLP",39,"Bagel","Plain"));
        inventoryItemList.add(new Bagel("BGLE",49,"Bagel","Everything"));
        inventoryItemList.add(new Bagel("BGLS",49,"Bagel","Sesame"));
        inventoryItemList.add(new Coffee("COFB",99,"Coffee","Black"));
        inventoryItemList.add(new Coffee("COFW",19,"Coffee","White"));
        inventoryItemList.add(new Coffee("COFC",29,"Coffee","Capuccino"));
        inventoryItemList.add(new Coffee("COFL",29,"Coffee","Latte"));
        inventoryItemList.add(new Filling("FILB",12,"Filling","Bacon"));
        inventoryItemList.add(new Filling("FILE",12,"Filling","Egg"));
        inventoryItemList.add(new Filling("FILC",12,"Filling","Cheese"));
        inventoryItemList.add(new Filling("FILX",12,"Filling","Cream Cheese"));
        inventoryItemList.add(new Filling("FILS",12,"Filling","Smoked Salmon"));
        inventoryItemList.add(new Filling("FILH",12,"Filling","Ham"));
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
