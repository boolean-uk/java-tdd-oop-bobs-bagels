package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {
    @Test
    void chooseFillingTest_ByProduct() {
        Bagel bagelWithoutFilling = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        String messageWithout = bagelWithoutFilling.chooseFilling(bagelWithoutFilling);
        Assertions.assertEquals("Category of product is not \"Filling\"", messageWithout);
    }

    @Test
    void chooseFillingTest_ByProduct() {
        Product filling = new Product("FILB", 0.12, "Filling", "Bacon");
        Bagel bagelWithFilling = new Bagel("BGLO", 0.49, "Bagel", "Onion", filling);
        String messageWith = bagelWithoutFilling.chooseFilling(bagelWithFilling);
        Assertions.assertEquals("Filling added to bagel", messageWith);
    }

    @Test
    void chooseFillingTest_ByVariant() {
        Bagel bagelWithoutFilling = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        String messageWithout = bagelWithoutFilling.chooseFilling(bagelWithoutFilling.getVariant());
        Assertions.assertEquals("Category of product is not \"Filling\"", messageWithout);
    }

    @Test
    void chooseFillingTest_ByProduct() {
        Product filling = new Product("FILB", 0.12, "Filling", "Bacon");
        Bagel bagelWithFilling = new Bagel("BGLO", 0.49, "Bagel", "Onion", filling);
        String messageWith = bagelWithoutFilling.chooseFilling(bagelWithFilling.getVariant());
        Assertions.assertEquals("Filling added to bagel", messageWith);
    }
}
