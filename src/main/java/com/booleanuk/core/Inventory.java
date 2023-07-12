package com.booleanuk.core;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private HashMap<String, ItemInterface> allItems;
    private ArrayList<ItemInterface> itemArrayList;
    public Inventory(ArrayList<ItemInterface> itemArrayList) {
        this.itemArrayList = itemArrayList;
        this.allItems = new HashMap<>();
//        this.allItems.put

        for (int i = 0; i < this.itemArrayList.size(); i++) {
                this.allItems.put(this.itemArrayList.get(i).getSku(),this.itemArrayList.get(i));
        }
    }

    public ItemInterface searchItem(String sku) {
        if(getAllItems().containsKey(sku)) {
            return getAllItems().get(sku);
        }
        System.out.println("This item does not exist");
        return null;
    }
    public HashMap<String, ItemInterface> getAllItems() {
        return allItems;
    }

    public void setAllItems(HashMap<String, ItemInterface> allItems) {
        this.allItems = allItems;
    }
}
