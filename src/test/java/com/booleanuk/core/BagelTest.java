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
            new Filling("FILE", 0.12, "Egg"),
            new Filling("FILC", 0.12, "Cheese")
    );

    @BeforeEach
    public void setUp() {
        bagel = new Bagel(SKU, PRICE, VARIANT, FILLINGS);
    }

    @Test
    public void testGetFillings() {
        List<Filling> fillings = bagel.getFillings();

        Assertions.assertEquals(FILLINGS, fillings);
    }

    @Test
    public void testSetFillings() {
        List<Filling> fillings = List.of(
                new Filling("FILB", 0.12, "Bacon"),
                new Filling("FILC", 0.12, "Cheese")
        );
        bagel.setFillings(fillings);

        Assertions.assertEquals(fillings, bagel.getFillings());
    }

    @Test
    public void testBagelsAreEqual() {
        Bagel bagel1 = new Bagel(SKU, PRICE, VARIANT, FILLINGS);
        Assertions.assertEquals(bagel, bagel1);
    }

    @Test
    public void testBagelsAreNotEqual() {
        Bagel bagel1 = new Bagel("BGLP", 0.39, "Plain",
                List.of(new Filling("FILE", 0.12, "Egg")));
        Assertions.assertNotEquals(bagel, bagel1);
    }
}