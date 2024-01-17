package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {

    @Test
    public void addFillingThatDoesntAlreadyExistTest() {
        Bagel bagel = new Bagel("Onion");
        Assertions.assertTrue(bagel.addFilling("Egg"));
    }

    @Test
    public void addFillingThatAlreadyExistsTest() {
        Bagel bagel = new Bagel("Onion");
        bagel.addFilling("Egg");
        Assertions.assertFalse(bagel.addFilling("Egg"));
    }
}
