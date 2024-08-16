package com.booleanuk.core;

public class Store {

   private int capacity = 10;

    public void updateCapacity(int capacity) {
        this.capacity += capacity;

    }

    public int getCapacity() {
        return capacity;
    }
}
