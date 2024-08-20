package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    Inventory inventory;
    Basket basket;

    @Test
    public void addCoffee() {
        this.inventory = new Inventory();
        this.basket = new Basket();
        Product coffee = basket.addCoffee(CoffeeVariant.CAPUCCINO);
        Assertions.assertTrue(basket.getAll().contains(coffee));
    }
}
