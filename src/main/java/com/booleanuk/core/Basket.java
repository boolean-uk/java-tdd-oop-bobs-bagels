package com.booleanuk.core;

import java.util.HashMap;

public class Basket {
    HashMap<String, Integer> basket;

    public Basket() {
        this.basket = new HashMap<>();
    }

    public int countTotalItems() {
        return this.basket.size();
    }
}
