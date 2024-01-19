package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    public void testSetBasket(){
        Manager manager = new Manager();
        Basket basket1 = new Basket();
        Basket basket2 = new Basket();
        manager.addBasket(basket1);
        manager.addBasket(basket2);

        basket1.add(new Bagel("BGLO"));
        basket1.add(new Bagel("BGLO"));
        basket2.add(new Bagel("BGLP"));

        //
        //Test if baskets with a larger size than new max clears
        manager.setBasketSize(1);

        Assertions.assertEquals(0, basket1.getProducts().size());
        Assertions.assertEquals(1, basket2.getProducts().size());

    }
}