package com.booleanuk.core;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private static Inventory singleton = null;
    private static List<InventoryItem> inventoryItemList = new ArrayList<InventoryItem>();

    private Inventory(){
        inventoryItemList.add(new InventoryItem("BGLO",0.49,"Bagel","Onion"));
        inventoryItemList.add(new InventoryItem("BGLP",0.39,"Bagel","Plain"));
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
