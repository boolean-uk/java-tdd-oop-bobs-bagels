package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    public BasketTest() {

    }

    @Test
    public void testCreateBasketAndAddProducts() {
        Basket b = new Basket();
        Bagel onion = new OnionBagel();
        Filling salmon = new SmokedSalmonFilling();
        b.addProduct(onion);
        b.addProduct(salmon);

        Assertions.assertEquals("FILS", b.getBasket().keySet().toArray()[1]);
    }

}
