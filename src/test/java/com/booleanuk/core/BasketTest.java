package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {


    @Test
    public void testBasket(){
        Basket basket = new Basket(10);
        Assertions.assertEquals(10, basket.capacity);
    }

    @Test
    public void testaddBagel() {
        Basket basket = new Basket(10);
        Bagel bagel = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.ONION);
        basket.addBagel(bagel);
        Assertions.assertTrue(basket.getListOfBasket().contains(bagel), "The bagel should be in the basket");

    }



}
