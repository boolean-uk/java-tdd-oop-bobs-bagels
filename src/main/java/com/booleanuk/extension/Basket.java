package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
    private int capacity;
    private Map<Item,Integer> items;

    public Basket(int capacity) {
        this.capacity = capacity;
        this.items = new HashMap<>();
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
        return items.keySet().contains(item);
    }

    public int getItemCount() {

        return items.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int freeSpace() {
        return capacity - getItemCount();
    }

    public void clearBasket() {
        items.clear();
    }

    public Map<Item,Integer> getItems() {
        return items;
    }

    public void add(Item item) {
        if (isFull()) throw new IllegalStateException("You can't add this item");
        else{
            int quantity = items.getOrDefault(item,0);
            items.put(item,quantity + 1);
        }
    }

    public void remove(Item item) {
        if (checkIfExists(item)) items.remove(item);
        else throw new IllegalArgumentException("You can't remove this item");
    }

    public double getTotalCost() {

        return items.entrySet().stream().map(entry -> entry.getKey().getPrice() * entry.getValue()).reduce(0L, Long::sum) / 100.0;
    }
}
