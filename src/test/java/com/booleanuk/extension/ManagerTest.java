package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ManagerTest {

    @Test
    public void testSetBasket(){
         Manager manager = new Manager();
         Basket basket1 = new  Basket();
         Basket basket2 = new Basket();
        manager.addBasket(basket1);
        manager.addBasket(basket2);

        basket1.add(new  Bagel("BGLO", 0.49, "Onion"));
        basket1.add(new  Bagel("BGLO", 0.49, "Onion"));
        basket2.add(new Bagel("BGLP", 0.39, "Plain"));

        //
        //Test if baskets with a larger size than new max clears
        manager.setBasketSize(1);

        Assertions.assertEquals(0, basket1.getProducts().size());
        Assertions.assertEquals(1, basket2.getProducts().size());

    }
}