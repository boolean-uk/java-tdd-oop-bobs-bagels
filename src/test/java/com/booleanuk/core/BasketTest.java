package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    private Basket basket;

    public BasketTest() {
        basket = new Basket(5);
    }

    @Test
    public void addToBasketTest() {
        Assertions.assertEquals(0,basket.getItems().size());
        basket.addItem("BGLO");
        basket.addItem("fake");
        basket.addItem("wrong item");
        Assertions.assertEquals(1,basket.getItems().size());

        basket.addItem("FILB");
        Assertions.assertEquals(2,basket.getItems().size());



    }

}
