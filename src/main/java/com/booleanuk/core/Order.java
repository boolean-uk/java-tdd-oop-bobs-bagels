
package com.booleanuk.core;

import java.util.ArrayList;

public class Order {
    private Basket basket;
    private Integer total;

    public Order() {
        this.basket = new Basket();
        this.total = 0;
    }

    public Basket getBasket() {
        return basket;
    }
}
