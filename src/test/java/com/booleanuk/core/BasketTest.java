package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class BasketTest {
    @Test
    public void addBagelToBasket(){
       Basket basket = new Basket();
       basket.add(new OnionBagel());
        Assertions.assertEquals(1, basket.numberOfItems());
    }

    @Test
    public void basketCanContainTwoItems(){
        Basket basket = new Basket();
        basket.add(new OnionBagel());
        basket.add(new BaconBagel());
        Assertions.assertEquals(2, basket.numberOfItems());
    }

    @Test
    public void removeBagel(){
        Basket basket = new Basket();
        basket.add(new BaconBagel());
        basket.remove(new BaconBagel());
        Assertions.assertEquals(0, basket.numberOfItems());
    }

    @Test
    public void showCapacity(){
        int expectedCapacity = 10;
        Basket basket = new Basket(expectedCapacity);
        Assertions.assertEquals(expectedCapacity,basket.capacity());
    }
}
