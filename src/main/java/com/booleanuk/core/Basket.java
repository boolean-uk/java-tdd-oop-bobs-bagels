package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {
    int capacity;
    double cost = 0;
    ArrayList<Foods> basketList;
    HashMap<String,Foods> inventory;

    public Basket(int size) {
        this.capacity =size;
        basketList = new ArrayList<>();
        initializeInventory();
    }

    public boolean add(Foods item) {
        if (basketList.size() >= this.capacity) {
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

    private void initializeInventory() {
        this.inventory = new HashMap<>();
        Bagel bagel1 = new Bagel("BGLO",0.49d,"Onion");
        Bagel bagel2 = new Bagel("BGLP",0.39d,"Plain");
        Bagel bagel3 = new Bagel("BGLE",0.49d,"Everything");
        Bagel bagel4 = new Bagel("BGLS",0.49d,"Sesame");
        inventory.put(bagel1.getSku(),bagel1);
        inventory.put(bagel2.getSku(),bagel2);
        inventory.put(bagel3.getSku(),bagel3);
        inventory.put(bagel4.getSku(),bagel4);
    }

    public double getTotalCost() {
        this.cost = 0;
        for (Foods food: basketList) {
            this.cost += inventory.get(food.getSku()).getPrice();
        }
        return (double) (cost/100);
    }
}
