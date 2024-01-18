package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasketTest {

    // Add functionality
    @Test
    public void addMultipleValidItems() {
        Basket basket = new Basket();
        boolean result = basket.addItem("Bagel Onion");
        Assertions.assertTrue(result);

        result = basket.addItem("Filling Bacon");
        Assertions.assertTrue(result);

        result = basket.addItem("Coffee Black");
        Assertions.assertTrue(result);

        result = basket.addItem("Bagel Onion");
        Assertions.assertTrue(result);

        Assertions.assertEquals("BGLO", basket.getBasketItemAtIndex(0));
        Assertions.assertEquals("FILB", basket.getBasketItemAtIndex(1));
        Assertions.assertEquals("COFB", basket.getBasketItemAtIndex(2));
        Assertions.assertEquals("BGLO", basket.getBasketItemAtIndex(3));

    }

    @Test
    public void addMultipleInValidItems() {
        Basket basket = new Basket();
        boolean result = basket.addItem("Choclate");
        Assertions.assertFalse(result);

        result = basket.addItem("Bagel Black");
        Assertions.assertFalse(result);

        result = basket.addItem("Filling Bagel");
        Assertions.assertFalse(result);

        Assertions.assertEquals(0, basket.getBasketSize());
    }

    // Remove
    @Test
    public void removeItemsValid() {
        Basket basket = new Basket();
        boolean result = basket.addItem("Bagel Onion");
        Assertions.assertTrue(result);

        Assertions.assertEquals(1, basket.getBasketSize());

        result = basket.removeItem("Bagel Onion");
        Assertions.assertTrue(result);

        Assertions.assertEquals(0, basket.getBasketSize());
    }

    // 3.
    @Test
    public void removeItemsNotInBasket() {
        Basket basket = new Basket();
        boolean result = basket.addItem("Bagel Onion");
        Assertions.assertTrue(result);

        Assertions.assertEquals(1, basket.getBasketSize());

        result = basket.removeItem("Bagel onion");
        Assertions.assertFalse(result);

        Assertions.assertEquals(1, basket.getBasketSize());
    }

    @Test
    public void removeOnlyOneValidItem() {
        Basket basket = new Basket();
        boolean result = basket.addItem("Bagel Onion");
        result = basket.addItem("Filling Bacon");
        result = basket.addItem("Bagel Onion");
        result = basket.addItem("Coffee Black");

        Assertions.assertEquals(4, basket.getBasketSize());

        result = basket.removeItem("Bagel Onion");
        Assertions.assertTrue(result);

        Assertions.assertEquals(3, basket.getBasketSize());
    }

    // Capacity
    @Test
    public void updateBasketCapacityTo5() {
        Basket basket = new Basket();
        int newCapacity = 5;
        int result = basket.changeCapacity(newCapacity);
        Assertions.assertEquals(5, result);
    }

    @Test
    public void updateBasketCapacityTo10() {
        Basket basket = new Basket();
        int newCapacity = 10;
        int result = basket.changeCapacity(newCapacity);
        Assertions.assertEquals(10, result);
    }

    @Test
    public void addBeyondCapacity() {
        Basket basket = new Basket();
        int newCapacity = 2;
        int intResult = basket.changeCapacity(newCapacity);
        boolean result = basket.addItem("Bagel Onion");
        result = basket.addItem("Filling Bacon");
        Assertions.assertTrue(result);
        result = basket.addItem("Bagel Onion");
        Assertions.assertFalse(result);

        Assertions.assertEquals(2, basket.getBasketSize());
    }


    // Overall Test after first five user stories
    @Test
    public void overallTest() {
        Basket basket = new Basket();
        int intResult = basket.changeCapacity(3);
        // Add 4 items to a max 3 items basket. Fours add should return false, the rest true
        Assertions.assertTrue(basket.addItem("Bagel Plain"));
        Assertions.assertTrue(basket.addItem("Bagel Sesame"));
        Assertions.assertTrue(basket.addItem("Coffee Capuccino"));
        Assertions.assertFalse(basket.addItem("Filling Cheese"));

        // Remove banana to add cheese and salami. Salami should return fail, the rest true
        Assertions.assertTrue(basket.removeItem("Bagel Sesame"));
        Assertions.assertTrue(basket.addItem("Bagel Everything"));
        Assertions.assertFalse(basket.addItem("Bagel Onion"));

        // Change capacity to 5 and add the extra bagels
        Assertions.assertEquals(5, basket.changeCapacity(5));
        Assertions.assertTrue(basket.addItem("Bagel Everything"));
        Assertions.assertTrue(basket.addItem("Bagel Everything"));

        // Remove ham bagel, that has now been added
        Assertions.assertTrue(basket.removeItem("Bagel Everything"));
    }

    // Check total cost in basket

    @Test
    public void testTotalCost() {
        Basket basket = new Basket();
        Assertions.assertEquals(0.0, basket.getTotal());

        Assertions.assertTrue(basket.addItem("Bagel Plain"));
        Assertions.assertTrue(basket.addItem("Bagel Sesame"));
        Assertions.assertTrue(basket.addItem("Coffee Capuccino"));
        Assertions.assertTrue(basket.addItem("Filling Cheese"));

        Assertions.assertEquals(2.29, basket.getTotal());

        Assertions.assertTrue(basket.removeItem("Bagel Sesame"));
        Assertions.assertTrue(basket.addItem("Bagel Everything"));
        Assertions.assertTrue(basket.addItem("Bagel Onion"));
        Assertions.assertEquals(2.78, basket.getTotal());

        Assertions.assertTrue(basket.addItem("Bagel Everything"));
        Assertions.assertTrue(basket.addItem("Bagel Everything"));
        Assertions.assertEquals(3.76, basket.getTotal());
    }

    // Get price of one item
    @Test
    public void testGetPrize() {
        Basket basket = new Basket();

        Assertions.assertEquals("0.39", basket.getPrice("Bagel Plain"));
        Assertions.assertEquals("0.49", basket.getPrice("Bagel Sesame"));
        Assertions.assertEquals("0.49", basket.getPrice("Bagel Everything"));
        Assertions.assertEquals("0.49", basket.getPrice("Bagel Onion"));
        Assertions.assertEquals("0.12", basket.getPrice("Filling Cheese"));
        Assertions.assertEquals("1.29", basket.getPrice("Coffee Capuccino"));
    }
}
