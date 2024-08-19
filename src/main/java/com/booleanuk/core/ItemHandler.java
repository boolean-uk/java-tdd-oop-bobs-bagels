package com.booleanuk.core;

import java.util.HashMap;

public class ItemHandler {

    private HashMap<String, Item> basket;
    private int basketCapacity;
    private HashMap<String, String> allItems;
    private int idTracker;

    public ItemHandler() {
        this.idTracker = 0;
    }

    public HashMap<String, Item> getBasket() {
        return basket;
    }

    public int getBasketCapacity() {
        return basketCapacity;
    }

    public HashMap<String, String> getAllItems() {
        return allItems;
    }

    public int getIdTracker() {
        return idTracker;
    }
}
