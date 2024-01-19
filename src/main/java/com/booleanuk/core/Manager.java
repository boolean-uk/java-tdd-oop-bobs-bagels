package com.booleanuk.core;

import java.util.ArrayList;

public class Manager {

    private ArrayList<Basket> baskets;

    public Manager(){
        baskets = new ArrayList<>();
    }

    public void addBasket(Basket basket){
        this.baskets.add(basket);
    }

    public void setBasketSize(int size){
        for(Basket basket: baskets){
            if(basket.getProducts().size() > size){
                basket.clearBasket();
            }
        }
        Basket.setMaxSize(size);
    }
}
