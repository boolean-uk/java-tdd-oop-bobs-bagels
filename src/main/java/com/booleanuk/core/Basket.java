package com.booleanuk.core;

import java.util.HashMap;

public class Basket {
    private HashMap<Product, Integer> basketItems;
    private int basketLimit;

    public Basket() {
        this.basketItems = new HashMap<>();
        this.basketLimit = 14; // Probably should be some way to set default limit
    }

    public Basket(int basketLimit) {
        this.basketItems = new HashMap<>();
        this.basketLimit = basketLimit;
    }

    public getBasketItems() {

    }

}
