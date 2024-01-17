package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Iterator;

public class Basket {
    private ArrayList<Item> items;
    public Basket(){
        items = new ArrayList<>();
    }
    public boolean addItem(String type, String name, int amount){
        Inventory i = Inventory.getInstance();
        if(i.checkInventory(type, name, amount)){
            items.addAll(i.getItems(type, name, amount));
            return true;
        }
        else{
            return false;
        }
    }
    public boolean removeItem(String name, String type){
            Iterator<Item> iterator = items.iterator();
            while(iterator.hasNext()){
                Item currentItem = iterator.next();
                if(currentItem.getType().equals(type) && currentItem.getName().equals(name)){
                    iterator.remove();
                    Inventory.getInstance().addItems(currentItem);
                    return true;
                }
            }
            return false;
    }

}
