package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Item> itemsInBasket;
    private int size;

    public Basket(ArrayList<Item> itemsInBasket, int size){
        this.itemsInBasket = itemsInBasket;
        this.size = size;
    }


}
