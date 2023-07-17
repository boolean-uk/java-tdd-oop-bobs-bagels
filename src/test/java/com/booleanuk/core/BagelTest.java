package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {


    @Test
    void chooseFillingTest_ByProductIsFilling() {
        Filling filling = new Filling("FILB", 0.12, "Filling", "Bacon");
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        String message = bagel.chooseFilling(filling);
        Assertions.assertEquals("Filling added to bagel", message);

        Assertions.assertEquals(bagel.getFilling().getSku(), filling.getSku());
        Assertions.assertEquals(bagel.getFilling().getPrice(), filling.getPrice());
        Assertions.assertEquals(bagel.getFilling().getName(), filling.getName());
        Assertions.assertEquals(bagel.getFilling().getVariant(), filling.getVariant());
    }

    @Test
    void chooseFillingTest_ByVariantDoesNotExist() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        String message = bagel.chooseFilling("chocolate");
        Assertions.assertEquals("Variant does not exist", message);
    }

    @Test
    void chooseFillingTest_ByVariantExist() {
        Product filling = new Product("FILB", 0.12, "Filling", "Bacon");
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        String message = bagel.chooseFilling("Bacon");
        Assertions.assertEquals("Filling added to bagel", message);

        Assertions.assertEquals(bagel.getFilling().getSku(), filling.getSku());
        Assertions.assertEquals(bagel.getFilling().getPrice(), filling.getPrice());
        Assertions.assertEquals(bagel.getFilling().getName(), filling.getName());
        Assertions.assertEquals(bagel.getFilling().getVariant(), filling.getVariant());
    }
}
