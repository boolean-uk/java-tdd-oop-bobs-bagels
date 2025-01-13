package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Item> basket = new ArrayList<>();
    private int maxCapacity = 5;
    private double totalCost = 0.0;

    public boolean addItem(Item item) {
        if (this.basket.size() <= this.maxCapacity - 1) {
            this.basket.add(item);
            return true;
        }
        return false;

    }

    public boolean removeItem(Item item) {
        if (this.basket.contains(item)) {
            this.basket.remove(item);
            return true;
        }
        return false;
    }

    public boolean changeCapacity(int newCapacity) {
        this.maxCapacity = newCapacity;
        return true;
    }

    public double checkCost(Item item) {
        return 0.0;
    }

    public void addFilling(Bagel bagel, Filling filling) {

    }

    public ArrayList<Item> getBasket(){
        return this.basket;
    }

    public double getTotalCost() {
        return this.totalCost;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

}
