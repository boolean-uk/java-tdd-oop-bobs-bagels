package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBasket {
    @Test
    public void testAddBagelToBasket(){
        Basket basket = new Basket();

        basket.addBagelToBasket("Bagel");
        Assertions.assertEquals("Bagel added to basket",basket.basketArr[0]);
    }

    @Test
    public void testRemoveBagelFromBasket(){
        Basket basket = new Basket();
        basket.addBagelToBasket("Bagel");
        basket.addBagelToBasket("Bagel");
        boolean result = basket.removeFromBasket("Bagel");
        Assertions.assertTrue(result);
    }

    @Test
    public void testAddToBasketDontExtendCapacity(){
        Basket basket = new Basket();

        basket.addBagelToBasket("Bagel");
        basket.addBagelToBasket("Bagel");
        basket.addBagelToBasket("Bagel");
        basket.addBagelToBasket("Bagel");
        basket.addBagelToBasket("Bagel");

        Assertions.assertEquals("Basket is full",basket.addBagelToBasket("Bagel"));
    }

    @Test
    public void testChangeArrayCapacity(){
        Basket basket = new Basket();

        basket.changeBasketCapacity(6);
        Assertions.assertEquals(6,basket.basketArr.length);
    }

    @Test
    public void testIfBagelExists(){
        Basket basket = new Basket();

        basket.addBagelToBasket("Bagel");
        basket.addBagelToBasket("Bagel");
        basket.addBagelToBasket("Bagel");
        basket.addBagelToBasket("Bagel");
        basket.addBagelToBasket("Bogle");
        boolean result = basket.removeFromBasket("FILE");
        Assertions.assertFalse(result);
    }

    @Test
    public void testTotalCostIsRight(){
        Basket basket = new Basket();

        basket.addBagelToBasket("Bagel");
        basket.addBagelToBasket("Bagel");
        basket.addBagelToBasket("Bagel");
        Assertions.assertEquals(1.87d,basket.totalCost());
    }

    @Test
    public void testShouldSeeBagelPrices(){
        Basket basket = new Basket();

        Assertions.assertEquals("String",basket.addBagelToBasket("Wrong"));
    }

    @Test
    public void testChooseFilling(){
        Basket basket = new Basket();

        //Not ready at all
        Assertions.assertEquals("HMM",basket.addBagelToBasket("Fill"));
    }

    @Test
    public void testShouldSeeFillingPrices(){
        Basket basket = new Basket();

        Assertions.assertEquals("String",basket.addBagelToBasket("HMM"));
    }

    @Test
    public void testCanOnlyAddExistingValues(){
        Basket basket = new Basket();
        basket.addBagelToBasket("Bagel");
        basket.addBagelToBasket("Bagel");
        Assertions.assertEquals("That product doesnt exist",basket.addBagelToBasket("Bogle"));
    }
}
