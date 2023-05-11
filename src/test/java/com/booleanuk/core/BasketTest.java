package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    public void testAddItem() {
        // Test for successfully added Bagel
        Basket basket = new Basket();
        Assertions.assertTrue(basket.addItem("Avocado"));
        Assertions.assertTrue(basket.items.contains("Avocado"));

        // Test for failure
        basket.addItem("Smoked Salmon");
        basket.addItem("Hummus");
        Assertions.assertFalse(basket.addItem("Grondboontjeboter"));
        Assertions.assertFalse(basket.items.contains("Grondboontjeboter"));
    }

    @Test
    public void testRemoveItem() {
        // Test for successfully removed Bagel
        Basket basket = new Basket();
        basket.addItem("Avocado");
        basket.addItem("Hummus");
        Assertions.assertTrue(basket.removeItem("Avocado"));
        Assertions.assertFalse(basket.items.contains("Avocado"));

        // Test for failure
        Assertions.assertFalse(basket.removeItem("Grondboontjeboter"));
    }

    @Test
    public void testUpdateBasketCapacity() {
        //Test for successfully updated capacity
        Basket basket = new Basket();
        Assertions.assertTrue(basket.updateBasketCapacity(5));
        Assertions.assertEquals(5, basket.basketCapacity);

        //Test for failed updated capacity (0 or negative number)
        Assertions.assertFalse(basket.updateBasketCapacity(0));
        Assertions.assertFalse(basket.updateBasketCapacity(-1));

        //Test for failed updated capacity (capacity made smaller than basket size)
        basket.addItem("Avocado");
        basket.addItem("Smoked Salmon");
        basket.addItem("Hummus");

        Assertions.assertFalse(basket.updateBasketCapacity(2));
}
