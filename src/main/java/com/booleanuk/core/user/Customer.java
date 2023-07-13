package com.booleanuk.core.user;

import com.booleanuk.core.basket.Basket;

public class Customer extends User {
    private final Basket basket;

    public Customer(String fullName) {
        super(fullName);
        basket = new Basket();
    }

    public Basket getBasket() {
        return basket;
    }


}
