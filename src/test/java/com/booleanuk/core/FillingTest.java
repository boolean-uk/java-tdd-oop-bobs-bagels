package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FillingTest {
    Filling filling = new Filling("bacon", 0.12);

    @Test
    public void testGetName() {
        Assertions.assertEquals("bacon", filling.getName());
    }

    @Test
    public void testGetCost() {
        Assertions.assertEquals(0.12, filling.getCost());
    }
}
