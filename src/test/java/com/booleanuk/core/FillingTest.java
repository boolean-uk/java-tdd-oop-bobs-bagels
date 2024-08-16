package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FillingTest {

    public FillingTest() {

    }

    @Test
    public void testCreateBaconFilling() {
        Filling bacon = new BaconFilling();

        Assertions.assertEquals("FILB", bacon.getSKU());
        Assertions.assertEquals(0.12, bacon.getPrice());
    }

    @Test
    public void testCreateSmokedSalmonFilling() {
        Filling salmon = new SmokedSalmonFilling();

        Assertions.assertEquals("FILS", salmon.getSKU());
        Assertions.assertEquals(0.12, salmon.getPrice());
    }

}
