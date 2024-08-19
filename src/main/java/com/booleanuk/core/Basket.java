package com.booleanuk.core;

import java.util.HashMap;

public class Basket {

    private final int DEFAULT_CAPACITY = 5;

    private HashMap<String, Integer> basket; // String=SKU, Integer=quantity in the basket
    private int capacity;
    private int size;

    public Basket() {
        this.capacity = DEFAULT_CAPACITY;
        this.basket = new HashMap<>();
        this.size = 0; // Number of products in the basket
    }

    public boolean addProduct(Product p) {
        if (isFull()) {
            return false;
        }

        if (this.basket.containsKey(p.getSKU())) {
            this.basket.replace(p.getSKU(), this.basket.get(p.getSKU()) + 1);
        } else {
            this.basket.put(p.getSKU(), 1);
        }

        ++this.size;
        return true;
    }

    public HashMap<String, Integer> getBasket() {
        return this.basket;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public boolean remove(Product p) {
        if (!this.basket.containsKey(p.getSKU())) return false;

        int currentQuantity = this.basket.get(p.getSKU());
        if (currentQuantity == 1) this.basket.remove(p.getSKU());
        else this.basket.replace(p.getSKU(), currentQuantity - 1);

        --this.size;
        return true;
    }

}
