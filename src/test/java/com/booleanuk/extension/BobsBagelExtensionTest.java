package com.booleanuk.extension;

import com.booleanuk.core.ShoppingManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BobsBagelExtensionTest {
    @Test
    public void testDiscounts() {
        ShoppingManager _sm = new ShoppingManager();

        _sm.basket.add("BGLP", 2);
        _sm.basket.add("FILB", 2);

        Assertions.assertEquals((0.39 + 0.12) * 2.0, _sm.basket.calculateTotalPriceWithDiscounts(), 0.0001);
    }
}
