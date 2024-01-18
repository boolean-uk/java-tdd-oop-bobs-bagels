package com.booleanuk.core;

import java.util.ArrayList;

public class Manager {

    private Basket basket;
    private Inventory inventory;
    private ArrayList<Basket> baskets;

    public Manager(){
        baskets = new ArrayList<>();
    }

    public void setBasketSize(int size){
        //for()
        Basket.setMaxSize(size);
    }
}
