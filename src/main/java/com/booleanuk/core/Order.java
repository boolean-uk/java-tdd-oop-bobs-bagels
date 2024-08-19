
package com.booleanuk.core;

public class Order {
    private final Basket basket;
    private Integer total;

    public Order() {
        this.basket = new Basket();
        this.total = 0;
    }

    public Basket getBasket() {
        return basket;
    }
}
