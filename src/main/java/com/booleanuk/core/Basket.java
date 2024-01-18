package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Item> items;
    private double totalCost;

    public Basket() {
        this.items = new ArrayList<>();
        this.totalCost = 0;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public double calculateTotalCost() {
        return -1;
    }

    public Item addItem(Item newItem) {
        return new Item("", -1, "", "");
    }

    public boolean capacityChanged() {
        return false;
    }

}
