package com.booleanuk.core;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Basket> baskets;
    private int maxCapacity;
    public Shop(){
        this.maxCapacity = 5;
    }

    public void createBasket(){
        baskets.add(new Basket(maxCapacity));
    }
    public boolean changeMaxCapacity(int maxCapacity){
        for(Basket b : baskets){
            if (b.getCurrentBasketSize() > maxCapacity){
                return false;
            }
        }
        return true;
    }
    public ArrayList<Basket> getAllBaskets(){
        return this.baskets;
    }
}
