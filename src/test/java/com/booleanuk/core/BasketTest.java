package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    Inventory inventory;
    Basket basket;

    @Test
    public void checkPrintBasket() {
        this.inventory = new Inventory();
        this.basket = new Basket(new Inventory());
        basket.printBasket();
    }

    @Test
    public void addCoffee() {
        this.inventory = new Inventory();
        this.basket = new Basket(new Inventory());
        basket.addCoffee("COFW");
        basket.printBasket();
        Assertions.assertEquals("COFW", basket.getAll().get(1).getSKU());
    }

    @Test
    public void addBagelAndFilling() {
        this.inventory = new Inventory();
        this.basket = new Basket(new Inventory());
        basket.addBagel("BAGE");
        basket.addFilling("FILS");
        basket.printBasket();
        Assertions.assertEquals("BAGE", basket.getAll().get(1).getSKU());
        Assertions.assertEquals("FILS", basket.getAll().get(2).getSKU());
    }
}
