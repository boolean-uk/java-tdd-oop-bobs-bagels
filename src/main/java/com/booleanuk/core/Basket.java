package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Item> items = new ArrayList<>();
    private int capacity = 10;
    private boolean isFull;

    public Basket(){
        this.isFull = false;
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public void checkCapacity(){
        if (items.size() == capacity){
            isFull = true;
            return;
        }
        isFull = false;
    }

    public boolean containsItem(String itemSku){
        for (Item item : items){
            if (item.getSku().equals(itemSku)){
                return true;
            }
        }
        return false;
    }

    public void addItem(String itemSku){
        checkCapacity();
        if (isFull){
            System.out.println("Your basket is full, cant add item!");
            return;
        }
        Item item = new Item(itemSku);
        items.add(item);
    }

    public void removeItem(String itemSku){
        for (Item item : items){
            if (item.getSku().equals(itemSku)){
                items.remove(item);
                return;
            }
        }
        System.out.println("This item does not exist in the basket!");
    }




}
