package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {
    /* Test use case 1 */
    @Test
    public void testAddingItemToBasket(){
        Basket basket = new Basket();
        Assertions.assertTrue(basket.addItem("Coffee", "Black", 10));
    }
}
