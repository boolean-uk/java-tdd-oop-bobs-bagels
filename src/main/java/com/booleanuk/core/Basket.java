package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Item> basketItems;
    private int capacity;


    public Basket(ArrayList<Item> items) {
        this.basketItems = items;
    }

    public String addItem(Item item) {
        if (!(basketItems.size() >= capacity)) {
            basketItems.add(item);
            return "Item added successfully!";
        }
        return "Basket is full!";
    }

    public String removeItem(Item item) {
        if (basketItems.contains(item)) {
            basketItems.remove(item);
            return "Item removed!";
        }
        return "Could not remove - item was never in basket";
    }

    public double getTotalPrice(ArrayList<Item> items) {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
