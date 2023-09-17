
package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {
    private int capacity;
    private ArrayList<Bagel> basket;

    public Basket() {}

    public Basket(int capacity) {
        this.capacity = capacity;
        this.basket = new ArrayList<>(capacity);
    }

    public String addBagel(Bagel bagel) {
        if (basket.size() < capacity) {
            basket.add(bagel);
            return "Bagel added to the basket";
        }
        return "Bagel is already in the basket";
    }

    public String removeBagel(Bagel bagel) {
        if (!basket.contains(bagel)) {
            return "This bagel does not exist in the basket";
        }
        basket.remove(bagel);
        return "Removed from the basket";
    }

    public boolean isBasketFull() {
        return basket.size() >= capacity;
    }

    public String setCapacity(int newCapacity) {
        capacity = newCapacity;
        basket.ensureCapacity(newCapacity);
        return "Capacity changed";
    }

    public double getTotalCost(HashMap<String, Filling> fillingInventory) {
        double totalCost = 0.0;
        for (Bagel bagel : basket) {
            totalCost += bagel.calculateBagelsCost(fillingInventory);
        }
        return totalCost;
    }
}
