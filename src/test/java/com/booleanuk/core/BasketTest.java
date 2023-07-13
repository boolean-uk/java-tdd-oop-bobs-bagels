package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    private Basket basket;

    public BasketTest() {
        basket = new Basket(2);
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

    @Test
    public void checkIfWeCanAddToBasketOverTheSizeOfCapacityTest() {
        basket.addItem("BGLO");
        basket.addItem("BGLO");
        basket.addItem("FILB");
        Assertions.assertEquals(2,basket.getItems().size());
        basket.addItem("BGLO");
        Assertions.assertEquals(2,basket.getItems().size());
    }

    @Test
    public void removeFromBasketTest() {
        basket.addItem("BGLO");
        basket.addItem("FILB");
        Assertions.assertEquals(2,basket.getItems().size());

        basket.removeItem("BGLOOOO");
        Assertions.assertEquals(2,basket.getItems().size());

        basket.removeItem("FILB");
        Assertions.assertEquals(1,basket.getItems().size());

        basket.removeItem("FILB");
        Assertions.assertEquals(1,basket.getItems().size());

        basket.removeItem("BGLO");
        Assertions.assertEquals(0,basket.getItems().size());

        basket.removeItem("BGLO");
        Assertions.assertEquals(0,basket.getItems().size());
    }

    @Test
    public void isBasketFullTest() {
        Assertions.assertTrue(basket.addItem("BGLO"));
        Assertions.assertTrue(basket.addItem("FILB"));
        Assertions.assertFalse(basket.addItem("FILB"));
    }

    @Test
    public void changingCapacityTest() {
        basket.addItem("BGLO");
        basket.addItem("FILB");
        Assertions.assertEquals(2,basket.getItems().size());

        basket.changeCapacity(4);
        basket.addItem("BGLO");
        basket.addItem("FILB");
        Assertions.assertEquals(4,basket.getItems().size());

        basket.addItem("BGLO");
        basket.addItem("FILB");
        Assertions.assertEquals(4,basket.getItems().size());
    }

    @Test
    public void doesItemExistInBasketSoItCanBeRemoveFromItTest() {
        basket.addItem("BGLO");
        basket.addItem("FILB");

        Assertions.assertTrue(basket.removeItem("BGLO"));
        Assertions.assertFalse(basket.removeItem("BGLO"));
        Assertions.assertTrue(basket.removeItem("FILB"));
        Assertions.assertFalse(basket.removeItem("FILB"));
        Assertions.assertFalse(basket.removeItem("strange item"));
    }

}
