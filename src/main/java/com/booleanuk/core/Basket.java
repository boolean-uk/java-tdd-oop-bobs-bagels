package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Item> items;
    private int basketSize;

    public Basket(){
        items = new ArrayList<>();
        basketSize = 4;
    }

    public String add(Item item, Menu menu){
        String msg = "";
        if(!menu.isInMenu(item)){
            msg = "Item not in inventory";
            return msg;
        }
        if(items.size() >= basketSize){
            return msg = "Basket is full";
        }
        items.add(item);
        if(menu.isInMenu(item)){
            msg = "Successfully added";

        }
        return msg;

    }

    public String remove(String itemName){
        String msg = "";
        for (Item i : items){
            if(i.getName() == itemName){
                items.remove(i);
                msg = "Successfully removed";
                return msg;
            }

        }

        msg = "No item found";

        return msg;
    }

    public Boolean resizeBasket(int newSize){
        if(newSize>15){
            return false;
        }
        basketSize = newSize;
        return true;
    }

    public Double calculateTotalCostOfBasket(){
        double total = 0;

        for(Item i : items){
            total += i.getPrice();
        }

        return total;
    }
}
