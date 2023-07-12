package com.booleanuk.core.user;

import com.booleanuk.core.basket.Basket;

public class Manager extends User {
    public Manager(String fullName) {
        super(fullName);
    }

    public boolean changeBasketSize(Basket basket, int newSize) {
        return false;
    }
}
