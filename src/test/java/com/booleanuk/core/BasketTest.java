package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasketTest {

    @Test
    public void addItemTest(){

        Basket basket = new Basket(2);
        String bagel1 = "plain bagel";

        Assertions.assertTrue(basket.addItem(bagel1));

    }

}

