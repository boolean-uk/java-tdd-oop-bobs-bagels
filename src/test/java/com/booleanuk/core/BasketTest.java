package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasketTest {

    @Test
    public void addBagelToBasket(){
        Basket basket = new Basket();

        basket.add("plain");
        Assertions.assertTrue(basket.add("plain"));
        Assertions.assertFalse(basket.add(""));
        Assertions.assertFalse(basket.add());
    }

}
