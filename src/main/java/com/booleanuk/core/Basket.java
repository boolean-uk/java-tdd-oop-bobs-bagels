package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    ArrayList<String> bagelBasket;
    int capacity;

    public Basket(){
        this.capacity = 6;
        this.bagelBasket = new ArrayList<>(capacity);
    }

    public boolean isEmpty(){
        return bagelBasket.isEmpty();
    }
    public boolean basketIsFull(){
        return bagelBasket.size() >= changeCapacity(capacity);
    }

    public String addBagel(String bagel){
        if (bagel == null && isEmpty()){
            return "Basket is empty";
        }
        else if (basketIsFull()){
            return "The Basket is full";
        }
        bagelBasket.add(bagel);
        return bagel + " added to your basket";
    }

    public String removeBagel(String bagel){
        if (!bagelBasket.contains(bagel)){
            return "Can not remove non-existing item.";
        }
        bagelBasket.remove(bagel);
        return bagel + " removed from your basket";
    }

    public int changeCapacity(int newCapacity){
        this.capacity = newCapacity;
        return newCapacity;
    }
}
