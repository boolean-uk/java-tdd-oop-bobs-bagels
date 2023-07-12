package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FillingTest {

    private Filling filling;

    public FillingTest() {
        this.filling = new Filling("FILB", 0.12, "Bacon");
    }

    @Test
    public void getSKUTest() {
        Assertions.assertEquals("filb", filling.getSKU().toLowerCase());
        Assertions.assertNotEquals("filbb", filling.getSKU().toLowerCase());
    }

    @Test
    public void getPriceTest() {
        Assertions.assertEquals(0.12, filling.getPrice());
        Assertions.assertNotEquals(1.20, filling.getPrice());
    }

    @Test
    public void getVariantTest() {
        Assertions.assertEquals("bacon", filling.getVariant().toLowerCase());
        Assertions.assertNotEquals("eggs", filling.getVariant().toLowerCase());
    }
}
