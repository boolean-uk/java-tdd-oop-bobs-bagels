package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasketTest {

    // ADD BAGELS TEST
    @Test
    public void testAddBagelToBasketReturnTrue(){
        Basket basket = new Basket();
        boolean result = basket.add("chocolate");
        Assertions.assertTrue(result);
    }

    @Test
    public void testAddBagelToBasketWithTrueAndFalse(){
        Basket basket = new Basket();
        Assertions.assertTrue(basket.add("vanilla"));
        Assertions.assertTrue(basket.add("chocolate"));
        Assertions.assertFalse(basket.add(""));
    }

    // REMOVE BAGEL TESTS
    @Test
    public void testRemoveBagelFromBasketReturnsTrue(){
        Basket basket = new Basket();

        basket.add("Cookie Dough");
        basket.add("Vanilla");
        basket.add("Chocolate");
        basket.add("Blueberry");

        Assertions.assertTrue(basket.remove("Chocolate"));
        Assertions.assertFalse(basket.remove("Plain"));
        Assertions.assertTrue(basket.remove("Cookie Dough"));
    }

    @Test
    public void testChangeCapacityOfBasket(){
        Basket basket = new Basket();
        Assertions.assertEquals(5, basket.capacity);
        basket.changeCapacity(10);
        Assertions.assertEquals(10, basket.capacity);
        basket.changeCapacity(-3);
        Assertions.assertEquals(5, basket.capacity);
    }

    @Test
    public void testBasketIsFullAfterCapacityChange(){
        Basket basket = new Basket();
        basket.changeCapacity(10);
        for (int i = 0; i < 8; i++) {
            basket.add("bagel: " + i);
        }
        Assertions.assertTrue(basket.checkIfNotFull());
        for (int i = 0; i < 8; i++) {
            basket.add("bagel: " + i);
        }
        Assertions.assertFalse(basket.checkIfNotFull());
    }

    @Test
    public void testAddBagelIfBasketIsFull(){
        Basket basket = new Basket();

        Assertions.assertTrue(basket.checkIfNotFull());
        basket.add("Cookie Dough");
        basket.add("Vanilla");
        basket.add("Chocolate");
        Assertions.assertTrue(basket.checkIfNotFull());
        basket.add("Blueberry");
        basket.add("Strawberry");
        basket.add("Plain");
        Assertions.assertFalse(basket.checkIfNotFull());
    }
    @Test
    public void testTryRemoveBagelInList(){
        Basket basket = new Basket();
        basket.add("Blueberry");
        basket.add("Strawberry");
        basket.add("Plain");
        basket.add("Cookie Dough");
        basket.add("Vanilla");
        basket.add("Chocolate");
        Assertions.assertEquals("Bagel not in list", basket.tryRemoveBagel("Redberry"));
        Assertions.assertEquals("Bagel is removed from list",basket.tryRemoveBagel("Cookie Dough"));
        Assertions.assertEquals("Bagel not in list", basket.tryRemoveBagel("Plain."));
        Assertions.assertEquals("Bagel is removed from list", basket.tryRemoveBagel("Blueberry"));
        Assertions.assertEquals("Bagel is removed from list", basket.tryRemoveBagel("Vanilla"));
    }

}
