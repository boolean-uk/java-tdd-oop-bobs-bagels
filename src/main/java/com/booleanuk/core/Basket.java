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

    public void addItemToBasket(String itemSKU){
        if(basket.containsKey(itemSKU)) {
            int oldQuantity = basket.get(itemSKU);
            basket.replace(itemSKU, oldQuantity, oldQuantity + 1);
        }else {
            basket.put(itemSKU, 1);
        }

    }
}
