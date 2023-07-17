package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.booleanuk.core.SKU.FILB;
import static com.booleanuk.extension.SKU.getAvailableFillings;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SKUTest {
    @Test
    public void testGettingAvailableFillings() {
        assertEquals(6, getAvailableFillings().size());
    }

    @Test
    public void testCheckingPriceOfFilling() {
        assertEquals(BigDecimal.valueOf(0.12), Basket.checkPrice(new Filling(FILB)));
    }
}
