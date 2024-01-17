package com.booleanuk.core.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Basket {
    private static final int DEFAULT_CAPACITY = 12;
    private ArrayList<Item> basket;
    private int capacity;

    public Basket() {
        this.basket = new ArrayList<>();
        this.capacity = 12;
    }
    public Basket(int capacity) {
        this.basket = new ArrayList<>();
        this.capacity = capacity;
    }

    public void clear() {
        basket.clear();
    }
}
