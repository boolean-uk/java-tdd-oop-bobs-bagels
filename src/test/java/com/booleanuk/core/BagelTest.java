package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {
    @Test
    public void createBagel() {
        Bagel bagel = new Bagel("BGLO", 0.39, "Onion");

        Assertions.assertEquals("Onion", bagel.getName());
    }
}
