package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static com.booleanuk.core.SKU.*;
import static org.junit.jupiter.api.Assertions.*;

public class BagelTest {

    @Test
    public void testCreatingBagelWithWrongSKU() {
        assertThrows(IllegalArgumentException.class, () -> new Bagel(COFB));
    }

    @Test
    public void testAddingFillingToBagel() {
        Bagel bagel = new Bagel(BGLO);

        assertTrue(bagel.addFilling(new Filling(FILB)));
        assertFalse(bagel.addFilling(new Filling(FILB)));
    }

    @Test
    public void testCreatingBagelUsingStrings() {
        Bagel bagel = new Bagel("Onion", new Filling("Bacon"));
        assertNotNull(bagel);
    }

    @Test
    public void testOrderingBagelOutOfInventory() {
        assertThrows(IllegalArgumentException.class, () -> new Bagel("Incorrect"));
    }
}
