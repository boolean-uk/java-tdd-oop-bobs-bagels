package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    public void getPriceWithDiscountsTest() {
        Basket basket = new Basket();
        basket.setCapacity(32);
        for(int i = 0; i < 7; ++i)
            basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLS);
        basket.addItem(CoffeeType.COFB);
        basket.addItem(CoffeeType.COFB);
        Assertions.assertEquals(2.49 + 2 * 1.25, basket.getTotalPrice());
        basket.clear();
        for(int i = 0; i < 6; ++i)
            basket.addItem(BagelType.BGLO);
        for(int i = 0; i < 12; ++i)
            basket.addItem(BagelType.BGLE);
        for(int i = 0; i < 13; ++i)
            basket.addItem(BagelType.BGLP);
        basket.addItem(CoffeeType.COFB);
        Assertions.assertEquals(2.49 * 3 + 3.99 + 1.25, basket.getTotalPrice());
    }

}
