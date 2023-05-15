package com.booleanuk.core;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private HashMap<String, Item> allItems;
    private ArrayList<Item> itemArrayList;
    public Inventory(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
        this.allItems = new HashMap<>();
//        this.allItems.put


        for (int i = 0; i < this.itemArrayList.size(); i++) {
                this.allItems.put(this.itemArrayList.get(i).getSku(),this.itemArrayList.get(i));
        }
    }

    public Item searchItem(String sku) {
        if(getAllItems().containsKey(sku)) {
            return getAllItems().get(sku);
        }
        System.out.println("This item does not exist");
        return null;
    }
    public HashMap<String, Item> getAllItems() {
        return allItems;
    }

    public void setAllItems(HashMap<String, Item> allItems) {
        this.allItems = allItems;
    }
}
