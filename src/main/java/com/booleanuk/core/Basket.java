package com.booleanuk.core;

import java.util.HashMap;

public class Basket {

    private final int DEFAULT_CAPACITY = 5;

    private HashMap<String, Integer> basket;
    private int capacity;

    public Basket() {
        this.capacity = DEFAULT_CAPACITY;
        this.basket = new HashMap<>();
    }

    public boolean addProduct(Product p) {
        if (this.basket.containsKey(p.getSKU())) {
            this.basket.replace(p.getSKU(), this.basket.get(p.getSKU()) + 1);
            return true;
        } else {
            this.basket.put(p.getSKU(), 1);
        }

        return true;
    }

    public HashMap<String, Integer> getBasket() {
        return this.basket;
    }

}
