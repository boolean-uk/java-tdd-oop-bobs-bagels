package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    protected ArrayList<Item> basketItems;

    public Basket(ArrayList<Item> items) {
        this.basketItems = items;
    }

    public boolean addItem(Item item) {
        if (!basketItems.contains(item)) {
            basketItems.add(item);
            return true;
        }
        return false;
    }

    public double getTotalPrice(ArrayList<Item> items) {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
}
