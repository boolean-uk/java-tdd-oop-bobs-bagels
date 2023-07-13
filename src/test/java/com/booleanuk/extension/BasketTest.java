package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    public void totalCostWithOnlyBagelDiscountsTest() {
        Basket basket = new Basket(30);
        basket.add("BGLO", 2);
        basket.add("BGLP", 12);
        basket.add("BGLE", 6);
        basket.add("FILC", 2);
        Assertions.assertEquals(7.7, basket.totalCost());
    }
}
