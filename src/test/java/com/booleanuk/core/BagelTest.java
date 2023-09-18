package com.booleanuk.core;

import com.booleanuk.core.Products.Bagel;
import com.booleanuk.core.Products.BagelType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class BagelTest {
    @Test
    public void testBagel() {
        Bagel bagel = new Bagel("BGLO", new BigDecimal("0.49"), "Bagel", BagelType.Onion);
        Assertions.assertEquals("BGLO" , bagel.getSku());
        Assertions.assertEquals(BigDecimal.valueOf(0.49), bagel.getPrice());
        Assertions.assertEquals("Bagel", bagel.getName());
        Assertions.assertEquals(BagelType.valueOf("Onion"), bagel.getVariant());
        Assertions.assertTrue( bagel.setVariant(BagelType.Everything));
        Assertions.assertEquals(BagelType.valueOf("Everything"), bagel.getVariant());
        Assertions.assertThrows(IllegalArgumentException.class, () -> bagel.setVariant(BagelType.valueOf("OnionGarlic")));
        Assertions.assertEquals(BagelType.valueOf("Everything"), bagel.getVariant());
    }
    @Test
    public void testInvalidBagelVariantInput() {
        int invalidNumericValue = 200;

        try {
            BagelType bagelType = BagelType.values()[invalidNumericValue];
            fail("Expected an exception for invalid numeric value");
        } catch (ArrayIndexOutOfBoundsException e) {
            // This exception should be thrown because the index is out of bounds
            // maybe handle such exceptions in the bagel class
            assertTrue(true);
        }
    }

}
