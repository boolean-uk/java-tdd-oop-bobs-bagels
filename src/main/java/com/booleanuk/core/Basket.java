package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {

    public ArrayList<String> bagels;
    int capacity;

    public Basket() {
        this.bagels = new ArrayList<>();
        this.capacity = 2;
    }

    public boolean add(String bagel) {
        if (isFull()) {
            return false;
        } else {
            return bagels.add(bagel);
        }
    }

    public boolean remove(String bagel) {
        return bagels.remove(bagel);
    }

    public boolean isFull() {
        return (bagels.size() >= capacity);
    }

    public void modifyCapacity(int newCapacity) {
        this.capacity = newCapacity;
    }

    public int getCapacity() {
        return capacity;
    }
}