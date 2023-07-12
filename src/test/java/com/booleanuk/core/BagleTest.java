package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagleTest {

    Bagle bagle;

    public BagleTest() {
        this.bagle = new Bagle("BGLO", 0.49, "Onion");
    }

    @Test
    public void getSKUTest() {
        Assertions.assertEquals("BGLO", bagle.getSKU());
    }
}
