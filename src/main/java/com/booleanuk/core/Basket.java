package com.booleanuk.core;

import java.util.HashMap;

public class Basket {
    HashMap<String, Integer> basket;

    public Basket() {
        this.basket = new HashMap<>();
    }

    public int countTotalItems() {
        return this.basket.size();
    }

    public HashMap<String, Integer> checkAllItems() {
        return this.basket;
    }

    public void addItemToBasket(Item item){
        if(basket.containsKey(item.getSKU())) {
            int oldQuantity = basket.get(item.getSKU());
            basket.replace(item.getSKU(), oldQuantity, oldQuantity + 1);
        }else {
            basket.put(item.getSKU(), 1);
        }

    }
}
