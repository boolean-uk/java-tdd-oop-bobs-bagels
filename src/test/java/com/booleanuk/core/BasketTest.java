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

        Bagel bagel = new Bagel();

        Assertions.assertTrue(basket.addItemToBasket(bagel));
        ArrayList<Item> itemList = basket.getItemList();

        Assertions.assertTrue(itemList.contains(bagel));

    }

}
