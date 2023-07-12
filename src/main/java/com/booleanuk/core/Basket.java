package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private static int defaultCapacity = 4;
    private int capacity;
    private int currentAmount = 0;
    private ArrayList<Item> items;
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getCurrentAmount() {
        return currentAmount;
    }
    public void setCurrentAmount(int currentAmount) {
        this.currentAmount = currentAmount;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    public static int getDefaultCapacity() {
        return defaultCapacity;
    }
    public static void setDefaultCapacity(int defaultCapacity) {
        Basket.defaultCapacity = defaultCapacity;
    }
    public Basket() {
        items = new ArrayList<Item>();
        capacity = defaultCapacity;
    }

    public boolean addBagel(Bagel bagel) {
        if(currentAmount == capacity)
            return false;
        items.add(bagel);
        ++currentAmount;
        return true;
    }
}
