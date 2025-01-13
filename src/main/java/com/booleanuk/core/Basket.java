package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Item> itemsInBasket;
    private int size;

    public Basket(ArrayList<Item> itemsInBasket, int size){
        this.itemsInBasket = itemsInBasket;
        this.size = size;
    }


    public String addItem(Item itemToAdd){
        if(this.itemsInBasket.size() < this.size){
            this.itemsInBasket.add(itemToAdd);
            return itemToAdd.getName() + " was added to your basket!";
        }
        return "Basket is full!";
    }

    public String removeItem(Item itemToRemove){
        for(Item item : itemsInBasket){
            if(item.getName().equals(itemToRemove.getName())){
                itemsInBasket.remove(item);
                return itemToRemove.getName() + " was removed from the basket!";
            }
        }
        return "Item do not exist in basket!";
    }

    public boolean changeSizeOfBasket(){
        return true;
    }
}
