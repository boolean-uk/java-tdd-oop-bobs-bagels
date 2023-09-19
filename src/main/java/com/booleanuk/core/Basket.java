package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {
    int capacity;
    ArrayList<Foods> basketList;

    public Basket(int size) {
        this.capacity =size;
        basketList = new ArrayList<>();
    }

    public boolean add(Foods item) {
        if (basketList.size() >= this.capacity) {
            return false;
        }
        if (!new Inventory().inventoryList.containsKey(item.getSku())) {
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
