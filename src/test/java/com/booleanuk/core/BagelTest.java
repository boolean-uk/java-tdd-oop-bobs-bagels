package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {

    @Test
    public void testCreateBagel(){
        Bagel bagel = new Bagel("plain");
        Bagel bagel2 = new Bagel("chocolate", 5.00);

        Assertions.assertEquals("plain", bagel.getName());
        Assertions.assertEquals(2.00, bagel.getPrice());

        Assertions.assertEquals("chocolate", bagel2.getName());
        Assertions.assertEquals(5.00, bagel2.getPrice());

    }
    @Test
    public void testGetPrice(){
        Bagel bagel = new Bagel("Onion");
        Assertions.assertEquals(2, bagel.getPrice());
        Bagel bagel2 = new Bagel("Red berry", 5);
        Assertions.assertEquals(5, bagel2.getPrice());
    }
    @Test
    public void testAddingVanillaFilling(){
        Bagel bagel = new Bagel("plain");
        Assertions.assertTrue(bagel.addFilling("Bacon"));
        Assertions.assertFalse(bagel.addFilling("brick"));
        Assertions.assertEquals("Bacon", bagel.getFilling());
    }
    @Test
    public void testGetPriceOfFilling(){
        Bagel bagel = new Bagel("plain");
        Assertions.assertEquals(2.00, bagel.checkPriceOfFilling("Cheese"));
        Assertions.assertEquals(3.00, bagel.checkPriceOfFilling("Ham"));
    }
}
