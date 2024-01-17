package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BasketTest {

    @Test
    public void testInit() {
        Basket basket = new Basket(5);
    }


    @Test
    public void testAddItemToBasket() {
        Basket basket = new Basket(5);

        Bagel bagel = new Bagel("Plain");

        Assertions.assertTrue(basket.addItemToBasket(bagel));
        ArrayList<Item> itemList = basket.getItemList();

        Assertions.assertTrue(itemList.contains(bagel));

    }

    @Test
    public void testRemoveItemFromBasket() {
        Basket basket = new Basket(5);

        Bagel bagel = new Bagel("Plain");
        Bagel bagel2 = new Bagel("Plain");

        Assertions.assertTrue(basket.addItemToBasket(bagel));

        Assertions.assertFalse(basket.getItemList().isEmpty());

        Assertions.assertTrue(basket.removeItemFromBasket(bagel));
        Assertions.assertFalse(basket.removeItemFromBasket(bagel2));

        Assertions.assertTrue(basket.getItemList().isEmpty());

    }

    @Test
    public void testCapacity() {
        Basket basket = new Basket(5);

        Assertions.assertEquals(5, basket.getBasketCapacity());

        Assertions.assertTrue(basket.setBasketCapacity(2));
        Assertions.assertFalse(basket.setBasketCapacity(0));
        Assertions.assertFalse(basket.setBasketCapacity(-1));

        Assertions.assertEquals(2, basket.getBasketCapacity());



    }

}
