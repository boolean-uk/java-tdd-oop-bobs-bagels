package com.booleanuk.core.basket;


import com.booleanuk.core.inventory.Inventory;
import org.junit.jupiter.api.Test;

public class BasketTest {

    Inventory inventory;
    Basket basket;

    @Test
    public void printBasket() {
        this.inventory = new Inventory();
        this.basket = new Basket(new Inventory());
        basket.printBasket();
    }
}
