package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    private Basket basket;
    private Item testItem;
    @Test
    public void addAndRemoveItemTest() {
        basket = new Basket(10);
        testItem = new Item("Bagel", 2.5, "test");
        basket.addItems(testItem, 2);
        Assertions.assertEquals(5, basket.getTotalCost());

        basket.removeItems(testItem, 1);
        Assertions.assertEquals(2.5, basket.getTotalCost());

    }

}
