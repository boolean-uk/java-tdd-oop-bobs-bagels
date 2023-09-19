package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    int capacity;
    ArrayList<Foods> basketList;
    Inventory inventory = new Inventory();

    public Basket(int capacity) {
        this.capacity = capacity;
        basketList = new ArrayList<>();
    }

    public boolean add(Foods item) {
        if (basketList.size() >= this.capacity) {
            return false;
        }
        if (!this.inventory.inventoryList.containsKey(item.getSku())) {
            return false;
        }
        this.basketList.add(item);
        return true;
    }

    public Boolean remove(String sku) {
        for (Foods food:basketList) {
            if (food.getSku().equals(sku)){
                basketList.remove(food);
                return true;
            }
        }
        return false;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public double getTotalCost() {
        int cost = 0;
        for (Foods food: basketList) {
            cost += food.getPrice();
        }
        return (double) (cost / 100.0);
    }

}
