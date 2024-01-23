package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FillingTest {

    @Test
    public void testInit() {
        Filling filling = new Filling("Bacon");

        Assertions.assertEquals(0.12, filling.getPrice());
        Assertions.assertEquals("Filling", filling.getName());
    }
}
