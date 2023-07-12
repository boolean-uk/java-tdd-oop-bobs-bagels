package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BagelTest {
    private Bagel bagel;
    private static final String SKU = "BGLO";
    private static final Double PRICE = 0.49;
    private static final String VARIANT = "Onion";
    private static final List<Filling> FILLINGS = List.of(
            // new Filling(...)
            // new Filling(...)
    );

    @BeforeEach
    public void setUp() {
        bagel = new Bagel(SKU, PRICE, VARIANT, FILLINGS);
    }

    @Test
    public void testGetFillings(){
        List<Filling> fillings = bagel.getFillings();

        Assertions.assertEquals(FILLINGS, fillings);
    }

}
