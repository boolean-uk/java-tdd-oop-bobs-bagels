package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FillingTest {
    @Test
    public void testAddingVanillaFilling(){
        Filling filling = new Filling(0.99, "FILB", "Bacon");
        Assertions.assertEquals(0.99, filling.getPrice());
        Assertions.assertEquals("Filling", filling.getItemName());
        Assertions.assertEquals("Bacon", filling.getVariant());
        Assertions.assertEquals("FILB", filling.getSku());
    }

}
