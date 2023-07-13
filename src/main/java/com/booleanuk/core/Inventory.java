package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private static Inventory singleton = null;
    private static List<InventoryItem> inventoryItemList = new ArrayList<>();

    private Inventory(){
        inventoryItemList.add(new InventoryItem("BGLO",49,"Bagel","Onion"));
        inventoryItemList.add(new InventoryItem("BGLP",39,"Bagel","Plain"));
        inventoryItemList.add(new InventoryItem("BGLE",49,"Bagel","Everything"));
        inventoryItemList.add(new InventoryItem("BGLS",49,"Bagel","Sesame"));
        inventoryItemList.add(new InventoryItem("COFB",99,"Coffee","Black"));
        inventoryItemList.add(new InventoryItem("COFW",19,"Coffee","White"));
        inventoryItemList.add(new InventoryItem("COFC",29,"Coffee","Capuccino"));
        inventoryItemList.add(new InventoryItem("COFL",29,"Coffee","Latte"));
        inventoryItemList.add(new InventoryItem("FILB",12,"Filling","Bacon"));
        inventoryItemList.add(new InventoryItem("FILE",12,"Filling","Egg"));
        inventoryItemList.add(new InventoryItem("FILC",12,"Filling","Cheese"));
        inventoryItemList.add(new InventoryItem("FILX",12,"Filling","Cream Cheese"));
        inventoryItemList.add(new InventoryItem("FILS",12,"Filling","Smoked Salmon"));
        inventoryItemList.add(new InventoryItem("FILH",12,"Filling","Ham"));
    }

    public static Inventory getInstance(){
        if (singleton == null)
            singleton = new Inventory();

        return singleton;
    }

    public static List<InventoryItem> getList(){
        return inventoryItemList;
    }

    public int getPriceBySku(String sku){
        for (InventoryItem i : inventoryItemList){
            if(sku.equals(i.sku)){
                return i.price;
            }
        } return 0;
    }

    public String getFullNameBySku(String sku){
        for (InventoryItem i : inventoryItemList){
            if(sku.equals(i.sku)){
                return i.getFullName();
            }
        } return "";
    }

    public static String getItemBySku(String sku){
        for (InventoryItem i : inventoryItemList) {
            if (sku.equals(i.sku)) {
                return i.toString();
            }
        } return "";
    }

    public String getAllItems(){
        String allItems = "";
        for (int i = 0; i < inventoryItemList.size(); i++) {
            allItems += "" + i + ". " + inventoryItemList.get(i).toString();
        }
        return allItems;
    }
    public String getSkuById(int i)
    {
      return inventoryItemList.get(i).sku;
    }

}
