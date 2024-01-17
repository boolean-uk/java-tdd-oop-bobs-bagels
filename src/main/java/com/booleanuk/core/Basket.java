package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {


    private ArrayList<Item> itemList = new ArrayList<>();
    private int basketCapacity = 0;

    public Basket(int basketCapacity) {
        this.basketCapacity = basketCapacity;

    }

    public boolean addItemToBasket(Item item) {
        itemList.add(item);
        return true;
    }

    public ArrayList<Item> getItemList() {
        return new ArrayList<>(itemList);
    }

    public boolean removeItemFromBasket(Item item) {
        if(this.itemList.contains(item)) {
            this.itemList.remove(item);
            return true;
        }
        return false;
    }


    public int getBasketCapacity() {
        return this.basketCapacity;
    }

    public boolean setBasketCapacity(int basketCapacity) {
        if(basketCapacity > 0) {
            this.basketCapacity = basketCapacity;
            return true;
        }
        return false;
    }
}
