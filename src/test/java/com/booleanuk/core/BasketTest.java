package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void testContainsItem(){
        Basket basket = new Basket();
        basket.addItem("BGLP");
        basket.addItem("FILE");
        Assertions.assertTrue(basket.containsItem("BGLP"));
        Assertions.assertTrue(basket.containsItem("FILE"));
    }

    @Test
    public void testAddItem(){
        Basket basket = new Basket();
        basket.addItem("BGLP");
        basket.addItem("FILE");
        Assertions.assertEquals(2, basket.getItems().size());
    }

    @Test
    public void testRemoveItem(){
        Basket basket = new Basket();
        basket.addItem("BGLP");
        basket.addItem("FILE");
        Assertions.assertTrue(basket.containsItem("BGLP"));
        Assertions.assertTrue(basket.containsItem("FILE"));
        basket.removeItem("FILE");
        Assertions.assertFalse(basket.containsItem("FILE"));

    }

    @Test
    public void testCheckCapacity(){
        Basket basket = new Basket();
        basket.checkCapacity();
        Assertions.assertFalse(basket.getIsFull());
        basket.addItem("BGLP");
        basket.addItem("FILE");
        basket.addItem("BGLP");
        basket.addItem("FILE");
        basket.addItem("BGLP");
        basket.addItem("FILE");
        basket.addItem("BGLP");
        basket.addItem("FILE");
        basket.addItem("BGLP");
        basket.addItem("FILE");
        basket.checkCapacity();
        Assertions.assertTrue(basket.getIsFull());
    }

    @Test
    public void testChangeCapacity(){
        Basket basket = new Basket();
        Assertions.assertEquals(10, basket.getCapacity());
        basket.changeCapacity(20);
        Assertions.assertEquals(20, basket.getCapacity());
    }

    @Test
    public void testTotalCost(){
        Basket basket = new Basket();
        basket.addItem("BGLP");
        basket.addItem("FILE");
        basket.addItem("COFB");
        Assertions.assertEquals(1.5f, basket.totalCost());
    }

}
