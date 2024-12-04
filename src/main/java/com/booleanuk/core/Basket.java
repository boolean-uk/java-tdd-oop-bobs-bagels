

package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Basket {


    private Map<Item, Integer> itemList;
    private int basketCapacity = 0;

    public Basket(int basketCapacity) {
        this.basketCapacity = basketCapacity;
        this.itemList = new HashMap<>();

    }

    //Need to check for basketCapacity
    public boolean addItemToBasket(Item item) {

        if(this.itemList.size() < getBasketCapacity()) {
            if(itemList.isEmpty()) {
                itemList.put(item, 1);
                return true;
            }

            for(Item itemFromList : getItemList().keySet()) {
                if(itemFromList.getSkuCode().equals(item.getSkuCode())) {
                    itemList.put(itemFromList, itemList.get(itemFromList) +1);
                    return true;
                }
            }
            itemList.put(item, +1);

        }

        return false;
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
