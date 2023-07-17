package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.booleanuk.extension.SKU.BGLO;
import static com.booleanuk.extension.SKU.FILB;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SKUTest {
    @Test
    public void testGettingAvailableFillings() {
        assertEquals(6, SKU.getAvailableFillings().size());
    }

    @Test
    public void testCheckingPriceOfFilling() {
        assertEquals(BigDecimal.valueOf(0.12), Basket.checkPrice(new Filling(FILB)));
    }

    @Test
    public void testCheckingBagelPrice() {
        assertEquals(BigDecimal.valueOf(0.49), Basket.checkPrice(new Bagel(BGLO)));
        assertEquals(BigDecimal.valueOf(0.61), Basket.checkPrice(new Bagel(BGLO, new Filling(FILB))));
    }
}
