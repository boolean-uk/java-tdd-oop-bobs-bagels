package com.booleanuk.core;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> currentInventory;

    public Inventory(){
        currentInventory = new ArrayList<>();
    }

    public Boolean isInInventory(Item item){
        return currentInventory.contains(item);
    }

    public String addItem(Item item){
        String msg = "Not added";
        currentInventory.add(item);
        if(currentInventory.contains(item)){
            msg = "Successfully added";
        }
        return msg;
    }

    public String addItems(ArrayList<Item> items){
        String msg = "Not added";

        currentInventory.addAll(items);


        if(currentInventory.equals(items)){
            msg = "Successfully added";
        }
        return msg;
    }

    public String removeItem(Item item){
        currentInventory.remove(item);
        String msg = "Not removed";

        if(!currentInventory.contains(item)){
            msg = "Successfully removed";
        }

        return msg;
    }

    public String removeItems(ArrayList<Item> items){
        String msg = "Not removed";

        currentInventory.removeAll(items);

        if(!currentInventory.equals(items)){
            msg = "Successfully removed";
        }

        return msg;
    }
}
