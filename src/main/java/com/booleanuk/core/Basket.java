package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {
    Inventory inventory;
    HashMap<Bagel, ArrayList<Filling>> basket;
    int maxCapacity = 5;
    int currentIndex = 0;

    public Basket(Inventory inventory) {
        this.inventory = inventory;
        this.basket = new HashMap<>();
    }

    public boolean addBagel(Bagel bagel) {
        if(currentIndex < maxCapacity) {
            basket.put(bagel, new ArrayList<>());
            currentIndex++;
            return true;
        }
        return false;
    }
}
