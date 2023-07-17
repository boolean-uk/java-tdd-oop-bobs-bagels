package com.booleanuk.extension;

public class Order {

    private final Basket basket;

    public Order(Basket basket) {
        this.basket = basket;
    }

    public Basket getBasket() {
        return basket;
    }
}
