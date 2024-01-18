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

        Assertions.assertEquals(5, basket.getItems());

        basket.add("BGLP");
        basket.add("BGLO");
        basket.add("BGLE");

        Assertions.assertEquals(8, basket.getItems());
    }

    @Test
    public void testAddProductNotInMenu(){
        boolean thrown = false;
        Basket basket = new Basket(new User());

        Assertions.assertEquals(0, basket.getItems());
        Assertions.assertFalse(basket.add("BLABLA"));
        Assertions.assertFalse(basket.add("BGLU"));
        Assertions.assertFalse(basket.add("HOOGA"));
        Assertions.assertEquals(0, basket.getItems());
        Assertions.assertTrue(basket.add("FILE"));
        Assertions.assertEquals(1, basket.getItems());
    }

    @Test
    public void testRemove(){
        Basket basket = new Basket(new User());
        basket.add("FILS");
        basket.add("COFL");
        basket.add("COFW");
        basket.add("COFC");

        Assertions.assertEquals(4, basket.getItems());
        Assertions.assertTrue(basket.remove("COFC"));
        Assertions.assertTrue(basket.remove("COFW"));
        Assertions.assertTrue(basket.remove("FILS"));
        Assertions.assertEquals(1, basket.getItems());
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
        Basket basket = new Basket(new Manager());
        basket.updateCapacity(2);

        Assertions.assertTrue(basket.add("COFB"));
        Assertions.assertTrue(basket.add("COFB"));
        Assertions.assertEquals(2, basket.getItems());
        Assertions.assertFalse(basket.add("COFB"));
        Assertions.assertFalse(basket.add("COFB"));
        Assertions.assertEquals(2, basket.getItems());
    }

    @Test
    public void testCapacityNegativeValue(){
        boolean errorThrown = false;
        Basket basket = new Basket(new Manager());

        try {
            basket.updateCapacity(-56);
        } catch (IllegalArgumentException e) {
            errorThrown = true;
        }

        Assertions.assertTrue(errorThrown);
    }

    @Test
    public void testShrinkingCapacityWhenItemsInBasket(){
        Basket basket = new Basket(new Manager());
        basket.add("FILE");
        basket.add("FILE");
        basket.add("FILE");
        basket.add("FILE");
        basket.add("FILE");

        Assertions.assertEquals(5, basket.getItems());

        basket.updateCapacity(3);

        Assertions.assertEquals(0, basket.getItems());
    }

    @Test
    public void testDisplayMenu(){
        Basket basket = new Basket(new User());
        basket.displayMenu();
    }

    @Test
    public void testTotalCost(){
        Basket basket = new Basket(new User());
        basket.add("COFB");
        basket.add("BGLS");
        basket.add("BGLP");
        basket.add("FILX");
        basket.add("FILS");

        Assertions.assertEquals(0.99 + 0.49 + 0.39 + 0.12 + 0.12, basket.totalCost());
    }
}
