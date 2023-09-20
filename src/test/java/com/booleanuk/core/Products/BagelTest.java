package com.booleanuk.core.Products;

import com.booleanuk.core.Products.Bagel;
import com.booleanuk.core.Products.BagelType;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class BagelTest {
    @Test
    public void testBagel() {
        Bagel bagel = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);
        assertEquals("BGLO", bagel.getSku());
        assertEquals(BigDecimal.valueOf(0.49), bagel.getPrice());
        assertEquals("Bagel", bagel.getName());
        assertEquals(BagelType.valueOf("Onion"), bagel.getVariant());
        assertTrue(bagel.setVariant(BagelType.Everything));
        assertEquals(BagelType.valueOf("Everything"), bagel.getVariant());
        assertThrows(IllegalArgumentException.class, () -> bagel.setVariant(BagelType.valueOf("OnionGarlic")));
        assertEquals(BagelType.valueOf("Everything"), bagel.getVariant());
    }

    @Test
    public void testInvalidBagelVariantInput() {
        int invalidNumericValue = 200;

        try {
            BagelType bagelType = BagelType.values()[invalidNumericValue];
            fail("Expected an exception for invalid numeric value");
        } catch (ArrayIndexOutOfBoundsException e) {
            // This exception should be thrown because the index is out of bounds
            assertTrue(true);
        }
    }

    @Test
    public void testAddFillingsToBagel() {
        Bagel bagel = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);

        Filling baconFilling = new Filling("FILB", new BigDecimal("0.12"), "Filling", FillingType.Bacon);
        Filling eggFilling = new Filling("FILE", new BigDecimal("0.12"), "Filling", FillingType.Egg);

        bagel.addFilling(baconFilling);
        bagel.addFilling(eggFilling);

        List<Filling> fillings = bagel.getFillings();

        assertEquals(2, fillings.size());
        assertTrue(fillings.contains(baconFilling));
        assertTrue(fillings.contains(eggFilling));
    }

    @Test
    public void testMaxFillingsLimit() {
        Bagel bagel = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);

        Filling baconFilling = new Filling("FILB", new BigDecimal("0.12"), "Filling", FillingType.Bacon);
        Filling eggFilling = new Filling("FILE", new BigDecimal("0.12"), "Filling", FillingType.Egg);
        Filling cheeseFilling = new Filling("FILC", new BigDecimal("0.12"), "Filling", FillingType.Cheese);
        assertTrue(bagel.addFilling(baconFilling));
        assertTrue(bagel.addFilling(baconFilling));
        assertTrue(bagel.addFilling(eggFilling));
        assertTrue(bagel.addFilling(eggFilling));
        assertTrue(bagel.addFilling(cheeseFilling));

        Filling hamFilling = new Filling("FILH", new BigDecimal("0.12"), "Filling", FillingType.Ham);
        assertFalse(bagel.addFilling(hamFilling));

        List<Filling> fillings = bagel.getFillings();

        assertEquals(5, fillings.size());
        assertTrue(fillings.contains(baconFilling));
        assertTrue(fillings.contains(eggFilling));
        assertTrue(fillings.contains(cheeseFilling));
        assertFalse(fillings.contains(hamFilling));
    }

    @Test
    public void testCalculateTotalPriceItemWithNoFillings() {
        Bagel bagel = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);
        BigDecimal expectedPrice = new BigDecimal("0.49");
        assertEquals(expectedPrice, bagel.calculateTotalPriceItem());
    }

    @Test
    public void testCalculateTotalPriceItemWithFillings() {
        Bagel bagel = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);

        Filling baconFilling = new Filling("FILB", new BigDecimal("0.12"), "Filling", FillingType.Bacon);
        Filling eggFilling = new Filling("FILE", new BigDecimal("0.12"), "Filling", FillingType.Egg);

        bagel.addFilling(baconFilling);
        bagel.addFilling(eggFilling);

        BigDecimal expectedPrice = new BigDecimal("0.49").add(new BigDecimal("0.12")).add(new BigDecimal("0.12"));

        assertEquals(expectedPrice, bagel.calculateTotalPriceItem());
    }
}
