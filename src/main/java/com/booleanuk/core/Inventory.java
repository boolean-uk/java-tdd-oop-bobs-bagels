package com.booleanuk.core;

import java.util.HashMap;

public class Inventory {
    private HashMap<Product, Integer> stock;

    public Inventory() {
        this.stock = new HashMap<>();
    }

}
