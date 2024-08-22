package com.booleanuk.core.basket;


import com.booleanuk.core.inventory.Inventory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    Inventory inventory;
    Basket basket;

    @Test
    public void printBasket() {
        inventory = new Inventory();
        basket = new Basket(new Inventory());
        basket.printBasket();
    }

    @Test
    public void addProductsToBasket() {
        inventory = new Inventory();
        basket = new Basket(new Inventory());

        basket.add(new Coffee("COFC"));
        basket.add(new Bagel("BAGE"));
        basket.add(new Filling("FILB"));

        Assertions.assertEquals(3, basket.getAll().size());
        basket.printBasket();
    }
}
