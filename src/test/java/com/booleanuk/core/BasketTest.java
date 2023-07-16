package com.booleanuk.core;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void addTest() {
        Basket basket = new Basket(5);
        Assertions.assertTrue(basket.add("BGLP", 1));
        Assertions.assertFalse(basket.add("BGLE", 8));
        Assertions.assertFalse(basket.add("Plastic", 3));
        Assertions.assertFalse(basket.add("BGLP", 0));
        Assertions.assertTrue(basket.add("FILE", 1));
    }

    @Test
    public void removeTest() {
        Basket basket = new Basket(10);
        basket.add("BGLP", 6);
        basket.add("BGLE", 2);
        basket.add("BGLS", 2);
        Assertions.assertTrue(basket.remove("BGLP", 4));
        Assertions.assertFalse(basket.remove("BGLE", 4));
        Assertions.assertFalse(basket.remove("Plastic", 2));
        Assertions.assertFalse(basket.remove("BGLP", 0));
    }

    @Test
    public void changeCapacityTest() {
        Basket basket = new Basket(10);
        basket.add("BGLP", 6);
        basket.add("BGLE", 2);
        basket.add("BGLS", 2);
        Assertions.assertTrue(basket.changeCapacity(15));
        Assertions.assertFalse(basket.changeCapacity(8));
    }

    @Test
    public void totalCostTest() {
        Basket basket = new Basket(10);
        basket.add("BGLP", 6);
        basket.add("BGLE", 2);
        basket.add("BGLS", 2);
        Assertions.assertEquals(4.3, basket.totalCost());
    }

    @Test
    public void checkCostOfProducts(){
        Basket basket = new Basket(10);
        Assertions.assertEquals(0.39, basket.checkCostOfProduct("BGLP"));
        Assertions.assertEquals(0.12, basket.checkCostOfProduct("FILE"));
        Assertions.assertEquals(0.0, basket.checkCostOfProduct("Pizza"));
    }

}
