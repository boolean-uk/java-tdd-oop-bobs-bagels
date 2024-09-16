package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private final List<Item> items;
    private int capacity;
    private double totalCost;

    public Basket() {
        this.items = new ArrayList<>();
        this.capacity = 5;
    }

    public boolean add(Item item) {
        if (isFull()) {
            return false;
        } else {
            items.add(item);
            totalCost += item.getPrice();
            return true;
        }
    }

    public boolean remove(Item item) {
        if (items.remove(item)) {
            totalCost -= item.getPrice();
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return (items.size() >= capacity);
    }

    public void modifyCapacity(int newCapacity) {
        this.capacity = newCapacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public double totalCost() {
        return totalCost;
    }

    public List<Item> getItems() {
        return items;
    }

/*    public int getQuantity(Item item) {
        int initialQuantity = 0;

        for(Item basketItems : items) {
            if(basketItems == item) {
                initialQuantity++;
            }
        }

        return initialQuantity;
    }*/
}