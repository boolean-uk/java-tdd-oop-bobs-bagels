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
        basket.add(new Bagel("BGLO",0.49, "Bagel", "Onion" ));
        boolean result =  basket.add(new Bagel("BGLO",0.49, "Bagel", "Onion" ));
        Assertions.assertFalse(result);

    }
    @Test
    public void removingItemWhenItemIsInBasket(){
        Basket basket = new Basket(4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        Bagel bagel2 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        basket.add(bagel1);
        basket.add(bagel2);
        Assertions.assertEquals("Onion Bagel removed from basket", basket.remove(bagel1));
    }
    @Test
    public void removingItemWhenBasketIsEmpty(){
        Basket basket = new Basket(4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        basket.add(bagel1);
        basket.remove(bagel1);
        Assertions.assertEquals("Basket is empty", basket.remove(bagel1));
    }
}
