package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private final ArrayList<Item> basket = new ArrayList<>();
    private int maxCapacity = 5;
    private double totalCost = 0.0;

    public boolean addItem(Item item) {
        if (this.basket.size() <= this.maxCapacity - 1) {
            this.basket.add(item);
            this.totalCost += item.getPrice();
            return true;
        }
        System.out.println("Basket full!");
        return false;

    }

    public boolean removeItem(Item item) {
        if (this.basket.contains(item)) {
            this.basket.remove(item);
            this.totalCost -= item.getPrice();
            return true;
        }
        System.out.println("No such item in the basket!");
        return false;
    }

    public boolean changeCapacity(int newCapacity) {
        if (newCapacity > 0) {
            this.maxCapacity = newCapacity;
            return true;
        }
        return false;
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
