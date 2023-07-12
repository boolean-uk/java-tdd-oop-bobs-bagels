package com.booleanuk.core;

import java.util.HashMap;

public class Basket {

    private int capacity;
    private HashMap<Product, Integer> basketList = new HashMap<>();
    private int productsQuantity;
    public Basket() {
        this.capacity = 5;
    }
    public Basket(int capacity) {
        this.capacity = capacity;
    }

    public HashMap<Product, Integer> getBasketList() {
        return basketList;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getProductsQuantity() {
        return productsQuantity;
    }
}
