package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Basket {


    private Map<Item, Integer> itemList;
    private int basketCapacity = 0;

    public Basket(int basketCapacity) {
        this.basketCapacity = basketCapacity;
        this.itemList = new HashMap<>();

    }

    public boolean addItemToBasket(Item item) {

        if(itemList.isEmpty()) {
            itemList.put(item, 1);
            return true;
        }
        itemList.put(item, itemList.get(item) +1);
        return true;
    }

    public Map<Item, Integer> getItemList() {
        return this.itemList;
    }

    public boolean removeItemFromBasket(Item item) {
        if(this.itemList.containsKey(item)) {
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
