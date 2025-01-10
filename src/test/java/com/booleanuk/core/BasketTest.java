package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void addingItemsToBasket() {
        Basket basket = new Basket();

        Assertions.assertTrue(basket.add(basket.stockList.get("BGLP")));
    }
}
