package com.booleanuk.core;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<InventoryItem> inventoryItemList = new ArrayList<InventoryItem>();

    public void Setup()
    {
        inventoryItemList.add(new InventoryItem("BGLO",0.49,"Bagel","Onion"));
        inventoryItemList.add(new InventoryItem("BGLP",0.39,"Bagel","Plain"));
    }
    public double getPriceBySku(String sku){
        return inventoryItemList.
    }

}
