package com.booleanuk.core.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Basket {
    private static final int DEFAULT_CAPACITY = 12;
    private ArrayList<Item> basket;
    private int capacity;

    public Basket() {
        this.basket = new ArrayList<>();
        this.capacity = 12;
    }
    public Basket(int capacity) {
        this.basket = new ArrayList<>();
        this.capacity = capacity;
    }

    public boolean addItem(Item item) {
        // TODO Decrease stock
        if (basket.size() >= capacity) {
            return false;
        }
        return basket.add(item);
    }

    public boolean removeItem(Item item) {
        // TODO Increase stock
        return basket.remove(item);
    }

    public double getTotalCost() {
        double cost = 0;
        for (Item item : basket) {
            cost += item.getPrice();
        }
        return cost;
    }
}
