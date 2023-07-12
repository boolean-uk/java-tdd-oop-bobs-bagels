package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.*;
import java.util.Map.Entry;

public class Basket {
    private final static int DEFAULT_CAPACITY = 10;

    private final Map<Item, Integer> items;
    private int capacity;

    public Basket() {
        items = new HashMap<>();
        capacity = DEFAULT_CAPACITY;
    }

    public Basket(int capacity) {
        this();
        this.capacity = capacity;
    }

    public boolean addItem(Item item) {
        if (isFull()) {
            return false;
        }

        if (items.containsKey(item)) {
            items.put(item, items.get(item) + 1);
        } else {
            items.put(item, 1);
        }
        return true;
    }

    public boolean removeItem(Item item) {
        if (isInBasket(item)) {
            items.put(item, items.get(item) - 1);
            if (items.get(item) <= 0) {
                items.remove(item);
            }
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return items.size() >= capacity;
    }

    public void setCapacity(int newCapacity) {
        if (newCapacity <= 0 || newCapacity < items.size()) {
            throw new IllegalArgumentException("Incorrect capacity");
        }
        capacity = newCapacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isInBasket(Item item) {
        return items.containsKey(item);
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Entry<Item, Integer> entry : items.entrySet()) {
            totalPrice = totalPrice.add(entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())));
        }
        return totalPrice;
    }

    public static BigDecimal checkPrice(Item item) {
        return item.getPrice();
    }
}
