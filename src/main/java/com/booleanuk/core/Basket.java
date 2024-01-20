package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Item> items;

    public Basket() {
        items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return new ArrayList<>(items);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public int getNoOfItems() {
        return items.size();
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    @Override
    public String toString() {
        return items.toString();
    }

}
