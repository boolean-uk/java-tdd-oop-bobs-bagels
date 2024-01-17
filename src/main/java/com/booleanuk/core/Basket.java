package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Iterator;

public class Basket {
    private ArrayList<Item> items;

    private int maxCapacity;
    private int currentCapacity;
    public Basket(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.currentCapacity = 0;
        items = new ArrayList<>();
    }
    public boolean addItem(String type, String name, int amount){
        if(amount + currentCapacity > maxCapacity){
            return false;
        }
        Inventory i = Inventory.getInstance();
        if(i.checkInventory(type, name, amount)){
            currentCapacity += amount;
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
    public ArrayList<Item> getAllItems(){
        return this.items;
    }
    public int getCurrentBasketSize(){
        return this.currentCapacity;
    }


}
