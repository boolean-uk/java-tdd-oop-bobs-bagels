package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<String, Integer> basket;
    private int totalSum;

    public Order() {
        this.totalSum = 0;
        this.basket = new HashMap<>();
    }

    public int getTotalSum() {
        return totalSum;
    }

    public void addProduct(Product product) {
        basket.put(product.getSKU(), 1);
        totalSum += product.getPrice();
    }

    public Map<String, Integer> getBasket() {
        return basket;
    }
}
