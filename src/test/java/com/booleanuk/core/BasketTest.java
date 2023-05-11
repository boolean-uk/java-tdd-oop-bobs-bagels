package com.booleanuk.core;

import com.booleanuk.core.models.Bagel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void addShouldBeTrue() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel("Onion", 0.49, "BGLO");

        Assertions.assertTrue(basket.add(bagel));
        Assertions.assertEquals(1, basket.shoppingBasket.size());
        Assertions.assertEquals(1, basket.sizeOfBasket);
    }
}
