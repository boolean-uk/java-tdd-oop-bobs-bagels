package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private final Map<String, Integer> basket;
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
        if (isBasketFull()) {
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

    public boolean removeProduct(Product product) {
        if (basket.containsKey(product.getSKU())) {
            int productCount = basket.get(product.getSKU());
            if (productCount > 1) {
                basket.put(product.getSKU(), productCount - 1);
            } else {
                basket.remove(product.getSKU());
            }
            totalSum -= product.getPrice();
            currentBasketCapacity--;
            return true;
        }
        System.out.println("Product not found in the basket");
        return false;
    }

    private boolean isBasketFull() {
        return currentBasketCapacity >= maxBasketCapacity;
    }

   public void incrementBasketCapacity() {
       int sizeToIncrement = 5;
       maxBasketCapacity += sizeToIncrement;
    }

    public int getMaxBasketCapacity() {
        return maxBasketCapacity;
    }
    public Map<String, Integer> getBasket() {
        return basket;
    }
}
