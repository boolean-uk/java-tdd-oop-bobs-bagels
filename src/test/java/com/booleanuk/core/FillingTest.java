package com.booleanuk.core;

import com.booleanuk.core.products.fillings.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FillingTest {

    public FillingTest() {

    }

    @Test
    public void testCreateBaconFilling() {
        Filling f = new BaconFilling();

        Assertions.assertEquals("FILB", f.getSKU());
        Assertions.assertEquals(0.12, f.getPrice());
    }

    @Test
    public void testCreateSmokedSalmonFilling() {
        Filling f = new SmokedSalmonFilling();

        Assertions.assertEquals("FILS", f.getSKU());
        Assertions.assertEquals(0.12, f.getPrice());
    }

    @Test
    public void testCreateCheeseFilling() {
        Filling f = new CheeseFilling();

        Assertions.assertEquals("FILC", f.getSKU());
        Assertions.assertEquals(0.12, f.getPrice());
    }

    @Test
    public void testCreateEggFilling() {
        Filling f = new EggFilling();

        Assertions.assertEquals("FILE", f.getSKU());
        Assertions.assertEquals(0.12, f.getPrice());
    }

    @Test
    public void testCreateCreamCheeseFilling() {
        Filling f = new CreamCheeseFilling();

        Assertions.assertEquals("FILX", f.getSKU());
        Assertions.assertEquals(0.12, f.getPrice());
    }

    @Test
    public void testCreateHamFilling() {
        Filling f = new HamFilling();

        Assertions.assertEquals("FILH", f.getSKU());
        Assertions.assertEquals(0.12, f.getPrice());
    }

}
