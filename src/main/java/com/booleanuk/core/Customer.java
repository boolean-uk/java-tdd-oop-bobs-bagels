package com.booleanuk.core;

import java.util.List;

public class Customer {
    Basket basket;

    public Customer() {
        basket = new Basket();
    }

    public void addToBasket(String item) throws Exception {
        basket.addToBasket(item);
    }
    public Basket getBasket()
    {
        return basket;
    }

}
