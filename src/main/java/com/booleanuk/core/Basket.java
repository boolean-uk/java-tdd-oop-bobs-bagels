package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Item> items;
    private int capacity;

    public Basket(int capacity) {
        items = new ArrayList<>();
        this.capacity = capacity;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getCapacity() {
        return capacity;
    }

    //I'd like to add a specific type of bagel to my basket.
    //I'd like to be able to choose fillings for my bagel.
    public boolean add(Item item) {
        if (items.size() < capacity) {
            items.add(item);
            return true;
        }
        return false;
    }

    //I'd like to remove a bagel from my basket.
    //I'd like to know if I try to remove an item that doesn't exist in my basket.

    public boolean removeItem(Item item) {
        if (items.contains(item)) {
            items.remove(item);
            return true;
        }
        return false;
    }

    public int getItemsCount() {
        return items.size();
    }

    //I'd like to know when my basket is full when I try adding an item beyond my basket capacity.

    public boolean isFull() {
        return items.size() >= capacity;
    }

    //I’d like to change the capacity of baskets.
    public void changeCapacity(int newCapacity) {
        if (capacity > newCapacity)
            throw new RuntimeException("New capacity cannot be smaller than the old one");
        capacity = newCapacity;

    }

    //I'd like to know the total cost of items in my basket.
    public double totalCost() {
        return items.stream()
                .map(Item::getPrice)
                .reduce(Double::sum)
                .orElse(0.0);
    }
}
