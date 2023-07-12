package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private static Inventory singleton = null;
    private static List<InventoryItem> inventoryItemList = new ArrayList<>();

    private Inventory(){
        inventoryItemList.add(new InventoryItem("BGLO",0.49,"Bagel","Onion"));
        inventoryItemList.add(new InventoryItem("BGLP",0.39,"Bagel","Plain"));
        inventoryItemList.add(new InventoryItem("BGLE",0.49,"Bagel","Everything"));
        inventoryItemList.add(new InventoryItem("BGLS",0.49,"Bagel","Sesame"));
        inventoryItemList.add(new InventoryItem("COFB",0.99,"Coffee","Black"));
        inventoryItemList.add(new InventoryItem("COFW",1.19,"Coffee","White"));
        inventoryItemList.add(new InventoryItem("COFC",1.29,"Coffee","Capuccino"));
        inventoryItemList.add(new InventoryItem("COFL",1.29,"Coffee","Latte"));
        inventoryItemList.add(new InventoryItem("FILB",0.12,"Filling","Bacon"));
        inventoryItemList.add(new InventoryItem("FILE",0.12,"Filling","Egg"));
        inventoryItemList.add(new InventoryItem("FILC",0.12,"Filling","Cheese"));
        inventoryItemList.add(new InventoryItem("FILX",0.12,"Filling","Cream Cheese"));
        inventoryItemList.add(new InventoryItem("FILS",0.12,"Filling","Smoked Salmon"));
        inventoryItemList.add(new InventoryItem("FILH",0.12,"Filling","Ham"));
    }

    public static Inventory getInstance(){
        if (singleton == null)
            singleton = new Inventory();

        return singleton;
    }

    public static List<InventoryItem> getList(){
        return inventoryItemList;
    }

//    public double getPriceBySku(String sku){
//        return inventoryItemList.
//    }

}
