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

        Assertions.assertEquals("BGLO", basket.basket.get(0));
        Assertions.assertEquals("FILB", basket.basket.get(1));
        Assertions.assertEquals("COFB", basket.basket.get(2));
        Assertions.assertEquals("BGLO", basket.basket.get(3));

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

        Assertions.assertEquals(0, basket.basket.size());
    }

    // Remove
    @Test
    public void removeItemsValid() {
        Basket basket = new Basket();
        boolean result = basket.addItem("Bagel Onion");
        Assertions.assertTrue(result);

        Assertions.assertEquals(1, basket.basket.size());

        result = basket.removeItem("Bagel Onion");
        Assertions.assertTrue(result);

        Assertions.assertEquals(0, basket.basket.size());
    }

    // 3.
    @Test
    public void removeItemsNotInBasket() {
        Basket basket = new Basket();
        boolean result = basket.addItem("Bagel Onion");
        Assertions.assertTrue(result);

        Assertions.assertEquals(1, basket.basket.size());

        result = basket.removeItem("Bagel onion");
        Assertions.assertFalse(result);

        Assertions.assertEquals(1, basket.basket.size());
    }

    @Test
    public void removeOnlyOneValidItem() {
        Basket basket = new Basket();
        boolean result = basket.addItem("Bagel Onion");
        result = basket.addItem("Filling Bacon");
        result = basket.addItem("Bagel Onion");
        result = basket.addItem("Coffee Black");

        Assertions.assertEquals(4, basket.basket.size());

        result = basket.removeItem("Bagel Onion");
        Assertions.assertTrue(result);

        Assertions.assertEquals(3, basket.basket.size());
    }

    /*

    // 4.

    @Test
    public void updateBasketCapacityTo5() {
        Basket basket = new Basket(3);
        int newCapacity = 5;
        int result = basket.changeBasketCapacity(newCapacity);
        Assertions.assertEquals(5, result);
    }

    @Test
    public void updateBasketCapacityTo10() {
        Basket basket = new Basket(3);
        int newCapacity = 10;
        int result = basket.changeBasketCapacity(newCapacity);
        Assertions.assertEquals(10, result);
    }

    // 5.

    @Test
    public void removeBananaFromBasketOnlyContainingChocolate() {
        Basket basket = new Basket(3);
        boolean addResult = basket.addBagel("choclate");
        boolean removeResult = basket.removeBagel("banana");
        Assertions.assertFalse(removeResult);
    }



    // Overall Test

    @Test
    public void overallTest() {
        Basket basket = new Basket(3);

        // Add 4 bagels to a max 3 bagel basket. Fours add should return false, the rest true
        Assertions.assertTrue(basket.addBagel("choclate"));
        Assertions.assertTrue(basket.addBagel("banana"));
        Assertions.assertTrue(basket.addBagel("creme"));
        Assertions.assertFalse(basket.addBagel("cheese"));

        // Remove banana to add cheese and salami. Salami should return fail, the rest true
        Assertions.assertTrue(basket.removeBagel("banana"));
        Assertions.assertTrue(basket.addBagel("cheese"));
        Assertions.assertFalse(basket.addBagel("salami"));

        // Change capacity to 5 and add the extra bagels
        Assertions.assertEquals(5, basket.changeBasketCapacity(5));
        Assertions.assertTrue(basket.addBagel("banana"));
        Assertions.assertTrue(basket.addBagel("salami"));

        // Remove ham bagel, that has now been added
        Assertions.assertFalse(basket.removeBagel("ham"));
    }

     */
}
