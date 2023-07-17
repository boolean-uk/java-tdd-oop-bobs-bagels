package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import static com.booleanuk.extension.SKU.*;
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
    public void testAddingFillingToBagelViaConstructor() {
        Basket basket = new Basket();
        basket.addItem(new Bagel(BGLO, new Filling(FILC)));
        assertEquals(2, basket.getItems().size());
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
