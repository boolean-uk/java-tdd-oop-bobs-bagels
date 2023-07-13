package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Item> items;
    private int capacity;
    private Inventory inventory;

    public Basket(int capacity) {
        items = new ArrayList<>();
        this.capacity = capacity;
        inventory = new Inventory();
    }

    public List<Item> getItems() {
        return items;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean add(Item item) {
        if (items.size() < capacity) {
            items.add(item);
            return true;
        }
        return false;
    }

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

    public boolean isFull() {
        return items.size() >= capacity;
    }

    public void changeCapacity(int newCapacity){
        if(capacity > newCapacity)
            throw new RuntimeException("New capacity cannot be smaller than the old one");
        capacity = newCapacity;

    }
    public double totalCost() {
        return items.stream()
                .map(Item::getPrice)
                .reduce(Double::sum)
                .orElse(0.0);
    }


}
