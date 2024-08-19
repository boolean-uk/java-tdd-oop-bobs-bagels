package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
    public void testBagel() {
        Bagel bagel = new Bagel("BGLO");
        assertEquals(bagel.getPrice(), 0.49);
    }
}
