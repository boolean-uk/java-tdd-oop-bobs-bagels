package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Store {
    private HashMap<Integer, Basket> baskets;

    public Store() {
        baskets = new HashMap<>();
    }
    public int createBasket() {
        Basket basket = new Basket();
        baskets.put(basket.hashCode(), basket);
        return basket.hashCode();
    }

    public HashMap<Integer,Basket> getBaskets() {
        return baskets;
    }

    public boolean addBagelToBasket(String onion, int basketId) {
        return false;
    }
}
