package com.booleanuk.core;

import java.util.HashMap;

public class Basket {
    private Integer basketSize;
    private HashMap<Item, Integer> basket = new HashMap<>();

    public Integer numberOfItemsInBasket(){
        return this.basket.size();
    }

    public String addItemToBasket(Item item){
        this.basket.put(item, 1);
        return item.variant + " " + item.name + " added to basket.";
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

