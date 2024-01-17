package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BasketTest {

    @Test
    public void testInit() {
        Basket basket = new Basket();
    }


    @Test
    public void testAddItemToBasket() {
        Basket basket = new Basket();

        Bagel bagel = new Bagel("Plain");

        Assertions.assertTrue(basket.addItemToBasket(bagel));
        ArrayList<Item> itemList = basket.getItemList();

        Assertions.assertTrue(itemList.contains(bagel));

    }

    @Test
    public void testRemoveItemFromBasket() {
        Basket basket = new Basket();

        Assertions.assertTrue(basket.addItemToBasket(new Bagel("Plain")));

        Assertions.assertFalse(basket.getItemList().isEmpty());

        Assertions.assertTrue(basket.removeItemFromBasket("Plain"));

        Assertions.assertTrue(basket.getItemList().isEmpty());

    }

    @Test
    public void testCapacity() {
        Basket basket = new Basket(5);

        basket.getCapacity();
        Assertions.assertEquals(basket.getBasketCapacity);

    }

}
