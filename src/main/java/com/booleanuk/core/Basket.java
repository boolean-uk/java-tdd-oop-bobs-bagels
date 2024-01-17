package com.booleanuk.core;

import java.util.ArrayList;

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

}
