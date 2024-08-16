package com.booleanuk.core;

import java.util.HashMap;

public class Basket {
    private Integer basketSize;
    private HashMap<Item, Integer> basket = new HashMap<>();

    public String addItemToBasket(Item item){
        return "";
    }

    public String removeItemFromBasket(Item item){
        return "";
    }

    public Double calculateBasketCost(){
        return 0.0;
    }

    public Boolean basketIsFull(){
        return false;
    }

    public boolean itemInBasket(){
        return false;
    }

    public String changeBasketSize(int newSize){
        return "";
    }
}

