package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private int capacity;
    private List<String> bagels;

    public Basket(int capacity) {
        this.capacity = capacity;
        this.bagels = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void changeCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<String> getBagels() {
        return bagels;
    }

    public void setBagels(List<String> bagels) {
        this.bagels = bagels;
    }

    public void add(String bagel) {
        if (isFull() && !checkIfExists(bagel)) System.out.println("Basket is full!");
        else bagels.add(bagel);
    }

    public void remove(String bagel) {
        if (checkIfExists(bagel)) bagels.remove(bagel);
        else System.out.println("No such bagel in a basket");
    }

    public boolean isFull() {
        return bagels.size() >= capacity;
    }

    public boolean checkIfExists(String bagel) {
        return bagels.contains(bagel);
    }


    public int getBagelCount() {
        return bagels.size();
    }

    public int freeSpace() {
        return capacity - getBagelCount();
    }

    public void clearBasket() {
        bagels.clear();
    }
}
