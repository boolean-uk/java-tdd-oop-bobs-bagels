package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class BasketTest {
    @Test
    public void addBagelToBasket(){
       Basket basket = new Basket();
       basket.add("Bagel");
        Assertions.assertEquals(1, basket.numberOfItems());
    }
}
