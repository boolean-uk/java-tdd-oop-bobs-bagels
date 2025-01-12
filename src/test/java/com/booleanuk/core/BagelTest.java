package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {

    @Test
    public void testBagelCreation() {
        Bagel bagel = new Bagel("BGLP", 0.39, "Plain");
        Assertions.assertEquals("BGLP",bagel.getId());
        Assertions.assertEquals(0.39, bagel.getPrice());
        Assertions.assertEquals("Plain", bagel.getDescription());
        Assertions.assertInstanceOf(Bagel.class, bagel);
    }

}
