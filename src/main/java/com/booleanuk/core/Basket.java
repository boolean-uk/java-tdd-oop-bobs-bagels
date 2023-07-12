package com.booleanuk.core;

import java.util.HashMap;

public class Basket {

    private HashMap<Product, Integer> basket = new HashMap<>();

    private int capacity = 5;


    public HashMap<Product, Integer> getBasket() {
        return basket;
    }

    public void add(Bagel bagel, int quantity) {
        basket.put(bagel,quantity);
    }

    public void removeProduct(Bagel bagel, int quantity) {
        if(basket.containsKey(bagel)){
            if(basket.get(bagel) > quantity){
                basket.replace(bagel,basket.get(bagel)-1 );
            }else{
                basket.remove(bagel);
            }
        }
    }

    public void changeCapacity(int capacity) {
        setCapacity(capacity);
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
