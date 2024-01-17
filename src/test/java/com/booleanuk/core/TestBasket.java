package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBasket {
    @Test
    public void testAdd(){
        Basket basket = new Basket(new User());
        basket.add("BGLP");
        basket.add("BGLO");
        basket.add("BGLE");
        basket.add("BGLO");
        basket.add("FILE");

        Assertions.assertEquals(5, basket.items);

        basket.add("BGLP");
        basket.add("BGLO");
        basket.add("BGLE");

        Assertions.assertEquals(8, basket.items);
    }

    @Test
    public void testAddProductNotInMenu(){
        boolean thrown = false;
        Basket basket = new Basket(new User());

        Assertions.assertEquals(0, basket.items);
        Assertions.assertFalse(basket.add("BLABLA"));
        Assertions.assertFalse(basket.add("BGLU"));
        Assertions.assertFalse(basket.add("HOOGA"));
        Assertions.assertEquals(0, basket.items);
        Assertions.assertTrue(basket.add("FILE"));
        Assertions.assertEquals(1, basket.items);
    }

    @Test
    public void testRemove(){
        Basket basket = new Basket(new User());
        basket.add("FILS");
        basket.add("COFL");
        basket.add("COFW");
        basket.add("COFC");

        Assertions.assertEquals(4, basket.items);

        Assertions.assertTrue(basket.remove("COFC"));
        Assertions.assertTrue(basket.remove("COFW"));
        Assertions.assertTrue(basket.remove("FILS"));
        Assertions.assertEquals(1, basket.items);
        Assertions.assertFalse(basket.remove("FILS"));
    }

    @Test
    public void testRemoveProductNotInBasket(){
        Basket basket = new Basket(new User());

        Assertions.assertFalse(basket.remove("COFC"));
        Assertions.assertFalse(basket.remove("COFW"));
        Assertions.assertFalse(basket.remove("BGLO"));

        basket.add("COFC");

        Assertions.assertFalse(basket.remove("BGLE"));
    }

    @Test
    public void testCapacity(){

    }

    @Test
    public void testShrinkingCapacityWhenItemsInBasket(){

    }

    @Test
    public void testDisplayMenu(){

    }

    @Test
    public void testTotalCost(){

    }
}
