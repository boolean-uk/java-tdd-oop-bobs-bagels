package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private int capacity;
    private List<Item> items;

    public Basket(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void changeCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return items.size() >= capacity;
    }

    public boolean checkIfExists(Item item) {
        return items.contains(item);
    }

    public int getItemCount() {
        return items.size();
    }

    public int freeSpace() {
        return capacity - getItemCount();
    }

    public void clearBasket() {
        items.clear();
    }

    public List<Item> getItems() {
        return items;
    }

    public void add(Item item) {
        if (isFull()) throw new IllegalStateException("You can't add this item");
        else items.add(item);
    }

    public void remove(Item item) {
        if (checkIfExists(item)) items.remove(item);
        else throw new IllegalArgumentException("You can't remove this item");
    }

    public double getTotalCost() {
          return items.stream().map(Item::getPrice).reduce(0L, Long::sum) / 100.0;
    }
}
