package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<String, Integer> basket;
    private int totalSum;
    private int maxBasketCapacity = 20;
    private int currentBasketCapacity;

    public Order() {
        this.totalSum = 0;
        this.basket = new HashMap<>();
        this.currentBasketCapacity = 0;
    }

    public int getTotalSum() {
        return totalSum;
    }

    public boolean addProduct(Product product) {
        if (currentBasketCapacity == maxBasketCapacity) {
            return false;
        }
        if (basket.containsKey(product.getSKU())) {
            basket.put(product.getSKU(), basket.get(product.getSKU()) + 1);
        } else {
            basket.put(product.getSKU(), 1);
        }
        totalSum += product.getPrice();
        currentBasketCapacity++;
        return true;
    }

    public Map<String, Integer> getBasket() {
        return basket;
    }
}
