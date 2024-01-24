package com.booleanuk.core;
import java.util.ArrayList;
import java.util.List;
// Class representing BagelBasket
class BagelBasket {
    private List<BasketItem> items;
    private int capacity;

    public BagelBasket(int capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    public boolean addBasketItem(BasketItem item) {
        if (isBasketFull()) {
            System.out.println("Basket is full. Cannot add more items.");
            return false;
        } else {
            items.add(item);
            return true;
        }
    }

    public boolean removeBasketItem(BasketItem item) {
        return items.remove(item);
    }

    public boolean isBasketFull() {
        return items.size() >= capacity;
    }

    public int getTotalCost() {
        int totalCost = 0;
        for (BasketItem item : items) {
            totalCost += item.getCost();
        }
        return totalCost;
    }

    public boolean changeBasketCapacity(int newCapacity) {
        if (newCapacity < items.size()) {
            System.out.println("Cannot reduce capacity below current basket size.");
            return false;
        } else {
            this.capacity = newCapacity;
            return true;
        }
    }
}