package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasketTest {

    // 1.
    @Test
    public void addChocolateBagelReturnTrue() {
        Basket basket = new Basket(3);
        boolean result = basket.addBagel("choclate");
        Assertions.assertTrue(result);
    }

    @Test
    public void addChocolateBagelTwiceReturnTrue() {
        Basket basket = new Basket(3);
        boolean result = basket.addBagel("choclate");
        result = basket.addBagel("choclate");
        Assertions.assertTrue(result);
    }

    // 2.

    @Test
    public void removeChocolateAfteraddingReturnTrue() {
        Basket basket = new Basket(3);
        boolean result = basket.addBagel("choclate");
        result = basket.removeBagel("choclate");
        Assertions.assertTrue(result);
    }

    @Test
    public void removeChocolateFromEmptyBasketReturnFalse() {
        Basket basket = new Basket(3);
        boolean result = basket.removeBagel("choclate");
        Assertions.assertFalse(result);
    }

    // 3.
    @Test
    public void addBagelsToAFullBasketReturFalse() {
        Basket basket = new Basket(3);
        boolean result = basket.addBagel("choclate");
        result = basket.addBagel("cheese");
        result = basket.addBagel("creme");
        result = basket.addBagel("ham");
        Assertions.assertFalse(result);
    }

    @Test
    public void repeatedlyAddChocolateToAFullBasketReturnTrue() {
        Basket basket = new Basket(3);
        boolean result = basket.addBagel("choclate");
        result = basket.addBagel("choclate");
        result = basket.addBagel("choclate");
        result = basket.addBagel("choclate");
        Assertions.assertTrue(result);
    }

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







}
