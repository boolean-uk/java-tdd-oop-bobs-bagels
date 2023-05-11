package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    ArrayList<Item> items;
    int capacity;

    public Basket() {
        this.items = new ArrayList<>();
        this.capacity = 5;
    }

    public Basket(int capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

}
