package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class BagelTest {

    Bagel bagel;
    Filling filling;

    @BeforeEach
    void beforeEach() {
        bagel = new Bagel("BV", BigDecimal.valueOf(12),"variantBagel");
        filling = new Filling("FV", BigDecimal.valueOf(3), "variantFilling");
    }

    @Test
    void shouldSetBagelFillings() {
        Assertions.assertEquals(0, bagel.getFillings().size());
        bagel.setFillings(List.of(filling));
        Assertions.assertEquals(1, bagel.getFillings().size());
    }

    @Test
    void shouldReturnPriceOfBagelAndFillings() {
        Assertions.assertEquals(BigDecimal.valueOf(12), bagel.getPrice());
        bagel.setFillings(List.of(filling));
        Assertions.assertEquals(BigDecimal.valueOf(15), bagel.getPrice());
    }
}
