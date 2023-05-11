package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void testAdd(){
        Basket basket = new Basket(2);

        Assertions.assertEquals(0,basket.getBagels().size());

        Assertions.assertFalse(basket.add("wrongSKU"));
        Assertions.assertEquals(0,basket.getBagels().size());

        Assertions.assertTrue(basket.add("BGLO"));
        Assertions.assertEquals(1,basket.getBagels().size());

        Assertions.assertTrue(basket.add("BGLP");
        Assertions.assertEquals(2,basket.getBagels().size());

        Assertions.assertFalse(basket.add("BGLE"));
        Assertions.assertEquals(2,basket.getBagels().size());
    }
}
