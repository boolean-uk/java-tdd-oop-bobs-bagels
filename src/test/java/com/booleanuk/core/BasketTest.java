package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    public void addingItemShouldReturnTrue(){
        Basket basket = new Basket( 4);
        Assertions.assertTrue(basket.add((new Bagel("BGLO",0.49, "Bagel", "onion"))));
        Assertions.assertTrue(basket.add((new Bagel("BGLP", 0.39, "Bagel", "Plain"))));
    }
    @Test
    public void addingItemShouldReturnFalse(){
        Basket basket = new Basket( 4);
        basket.add(new Bagel("BGLO",0.49, "Bagel", "onion" ));
        boolean result =  basket.add(new Bagel("BGLO",0.49, "Bagel", "onion" ));
        Assertions.assertFalse(result);

    }
}
