package com.booleanuk.core;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Basket {
    private ArrayList<Bagel> bagels;
    private int basketSize;

    public Basket(int basketSize) {
        bagels = new ArrayList<>();
        this.basketSize = basketSize;
    }

    public int size() {
        return bagels.size();
    }

    public void addBagel(Bagel bagel) {
        if (bagels.size() < basketSize) {
            bagels.add(bagel);
        }
    }

    public void removeBagel(Bagel bagel) {
        if (!bagels.contains(bagel)) {
            throw new NoSuchElementException("No such bagel exists");
        }
        bagels.remove(bagel);
    }

    public ArrayList<Bagel> getBagels() {
        return new ArrayList<>(bagels);
    }

    public void setBasketSize(int basketSize) {
        if (basketSize < bagels.size()) {
            bagels.clear();
        }
        this.basketSize = basketSize;
    }

    public float calculateCost() {
        float sum = 0.0f;
        for (Bagel b: bagels) {
            sum += b.calculateCost();
        }
        return sum;
    }
}
