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
        Assertions.assertEquals("filb", filling.getSKU());
        Assertions.assertNotEquals("filbb", filling.getSKU());
    }
}
