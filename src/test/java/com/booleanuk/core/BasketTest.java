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

    @Test
    public void testItem(){
        basket = new Basket(10);
        testItem = new Item("Bagel", 2.5, "test");
        basket.addItems(testItem, 2);

        Assertions.assertEquals("Bagel", testItem.getType());
        Assertions.assertEquals(2.5, testItem.getPrice());
        Assertions.assertEquals("test", testItem.getVariant());
    }

    @Test
    public void testBasketCapacity(){
        basket = new Basket(5);
        testItem = new Item("Bagel", 1, "test");
        basket.addItems(testItem, 3);

        Assertions.assertFalse(basket.addItems(testItem, 3));
        Assertions.assertTrue(basket.addItems(testItem, 2));
    }
    @Test
    public void changeBasketCapacity(){
        basket = new Basket(5);
        Assertions.assertTrue((basket.changeCapacity(10)));

        testItem = new Item("Bagel", 1, "test");
        basket.addItems(testItem, 10);
        Assertions.assertFalse((basket.changeCapacity(9)));
        Assertions.assertTrue((basket.changeCapacity(20)));
    }

    @Test
    public void showBasket(){
        basket = new Basket(5);
        testItem = new Item("Bagel", 1, "test");
        basket.addItems(testItem, 1);

        Assertions.assertEquals("Bagel, 1, test", basket.showBasket());


    }


}
