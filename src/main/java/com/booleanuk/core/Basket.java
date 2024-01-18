package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Iterator;

public class Basket {
    private ArrayList<Item> items;

    private int maxCapacity;

    public Basket(int maxCapacity){
        this.maxCapacity = maxCapacity;
        items = new ArrayList<>();
    }
    public boolean addItem(String type, String name, int amount){
        if(amount + this.items.size() > maxCapacity){
            return false;
        }
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

    public boolean changeBasketCapacity(int capacity){
        return capacity >= this.items.size();
    }
    public double getTotalCost(){
        double total = 0;
        for(Item i : this.items){
            if(i instanceof Bagel){
                Bagel bagel = (Bagel) i;
                for(Filling f : bagel.getFillings()){
                    total+= f.getPrice();
                }
            }
            total += i.getPrice();
        }
        return total;
    }


}
