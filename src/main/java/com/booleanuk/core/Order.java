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
        if (basket.containsKey(product.getSKU())) {
            basket.put(product.getSKU(), basket.get(product.getSKU()) + 1);
        } else {
            basket.put(product.getSKU(), 1);
        }
        totalSum += product.getPrice();
    }

    public Map<String, Integer> getBasket() {
        return basket;
    }
}
