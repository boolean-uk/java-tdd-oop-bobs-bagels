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

    }

    @Test
    public void testChangeCapacity(){

    }

    @Test
    public void testTotalCost(){

    }

}
