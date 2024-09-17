package com.booleanuk.core.user;

import com.booleanuk.core.basket.Basket;

public class Manager extends User {
    public Manager(String fullName) {
        super(fullName);
    }

    public boolean changeBasketSize(Basket basket, int newSize) {
        if (newSize < basket.getProductsAmount() || newSize <= 1) {
            throw new IllegalArgumentException("Can't change capacity below actual amount of items");
        }

        basket.setCapacity(newSize);
        return true;
    }
}
