package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    ArrayList<Item> items;
    int capacity;
    Inventory inventory;

    public Basket() {
        this.items = new ArrayList<>();
        this.capacity = 3;
        this.inventory = new Inventory();
    }

    public Basket(int capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    public boolean add(Item order){
        if (!(this.items.size() < this.capacity)){
            System.out.println("Could not add item, basket is full!");
            return false;
        }


        this.items.add(order);
        return true;
    }
}
