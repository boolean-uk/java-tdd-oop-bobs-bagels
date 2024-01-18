package com.booleanuk.core;

import java.util.HashMap;

public class Basket {
    private HashMap<Item, Integer> basketContent;
    private int basketCapacity;

    public Basket(int basketCapacity) {
        this.basketContent = new HashMap<>();
        this.basketCapacity = basketCapacity;
    }

    public HashMap<Item, Integer> getBasketContent() {
        return this.basketContent;
    }

    public int getBasketCapacity() {
        return this.basketCapacity;
    }

    public void add(Item item) {

    }

    public void remove(Item item) {

    }

    public double totalCost() {
        return 0.0;
    }

    public String changeCapacity(int newCapacity) {
        return "";
    }
}
