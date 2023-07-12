package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Basket {
    private final static int DEFAULT_CAPACITY = 10;

    private final List<Bagel> bagels;
    private int capacity;

    public Basket() {
        bagels = new ArrayList<>();
        capacity = DEFAULT_CAPACITY;
    }

    public Basket(int capacity) {
        this.bagels = new ArrayList<>();
        this.capacity = capacity;
    }

    public boolean addItem(Bagel bagel) {
        if (isFull()) {
            return false;
        }
        return bagels.add(bagel);
    }

    public boolean removeItem(UUID id) {
        Bagel bagel = bagels.stream()
                .filter(b -> b.getId()
                .equals(id))
                .findFirst()
                .orElse(null);
        if (!isInBasket(bagel)) {
            return false;
        }
        return bagels.remove(bagel);
    }

    public boolean isFull() {
        return bagels.size() >= capacity;
    }

    public void setCapacity(int newCapacity) {
        if (newCapacity <= 0 || newCapacity < bagels.size()) {
            throw new IllegalArgumentException("Incorrect capacity");
        }
        capacity = newCapacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isInBasket(Bagel bagel) {
        return bagels.stream().anyMatch(b -> b.getVariant().equals(bagel.getVariant()));
    }
}
