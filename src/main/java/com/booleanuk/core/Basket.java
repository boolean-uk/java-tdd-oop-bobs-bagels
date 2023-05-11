package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    ArrayList<Item> items;
    int capacity;
    Inventory inventoryList;

    public Basket() {
        this.items = new ArrayList<>();
        this.capacity = 5;
        this.inventoryList = new Inventory();
    }

    public Basket(int capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    public boolean add(Item order){
        this.items.add(order);
        return true;
    }

}
