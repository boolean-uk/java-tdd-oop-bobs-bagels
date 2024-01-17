package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBasket {
    @Test
    public void testAddBagelToBasket(){
        Basket basket = new Basket();

        basket.addToBasket("BGLO");
        Assertions.assertEquals("BGLO",basket.basketArr[0]);
    }

    @Test
    public void testRemoveBagelFromBasket(){
        Basket basket = new Basket();
        basket.addToBasket("BGLO");
        basket.addToBasket("COFB");
        boolean result = basket.removeFromBasket("BGLO");
        Assertions.assertTrue(result);
    }

    @Test
    public void testAddToBasketDontExtendCapacity(){
        Basket basket = new Basket();

        basket.addToBasket("BGLO");
        basket.addToBasket("BGLP");
        basket.addToBasket("COFB");
        basket.addToBasket("COFB");
        basket.addToBasket("FILB");
        boolean result = basket.addToBasket("FILC");
        Assertions.assertFalse(result);
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

        basket.addToBasket("BGLO");
        basket.addToBasket("BGLP");
        basket.addToBasket("COFB");
        basket.addToBasket("COFB");
        basket.addToBasket("FILB");
        boolean result = basket.removeFromBasket("FILE");
        Assertions.assertFalse(result);
    }
}
