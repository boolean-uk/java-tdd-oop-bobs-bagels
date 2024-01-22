package com.booleanuk.extension;

import com.booleanuk.core.ShoppingManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BobsBagelExtensionTest {
    @Test
    public void testDiscounts() {
        ShoppingManager _sm = new ShoppingManager();

        _sm.basket.add("BGLO", 2);
        _sm.basket.add("BGLP", 12);
        _sm.basket.add("BGLE", 6);
        _sm.basket.add("COFB", 3);

        Assertions.assertEquals(10.43, _sm.basket.calculateTotalPriceWithDiscounts(), 0.0001);

        _sm.basket.clearBasket();

        _sm.basket.add("BGLP", 16);

        Assertions.assertEquals(5.55, _sm.basket.calculateTotalPriceWithDiscounts(), 0.0001);
    }
}
