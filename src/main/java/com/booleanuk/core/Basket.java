package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Product> list = new ArrayList<>();
    private int capacity;

    public Basket(int capacity) {
        this.capacity = capacity;
    }

    public boolean add(Product product) {
        if (list.size() <= capacity) {
            return list.add(product);
        } else {
            return false;
        }
    }

    public boolean remove(Product product) {
        if (list.contains(product)) {
            return list.remove(product);
        }
        return false;
    }

    public ArrayList<Product> getList() {
        return list;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean setCapacity(int capacity) {
        if (capacity <= list.size()) {
            return false;
        }
        this.capacity = capacity;
        return true;
    }
}
