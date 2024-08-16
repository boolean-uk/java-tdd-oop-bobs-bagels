package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    public BasketTest() {

    }

    @Test
    public void testCreateBasketAndAddBagel() {
        Basket b = new Basket();
        b.addProduct(new OnionBagel());

        Assertions.assertEquals("BGLO", b.getBasket().values().toArray()[0]);
    }

}
