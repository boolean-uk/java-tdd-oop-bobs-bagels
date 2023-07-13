package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FillingsTest {

    @Test
    public void testType () {
        ItemInterface item = new Fillings("Fillings", 0.12, "FILB", "Bacon");
        Assertions.assertEquals("Fillings", item.getType());
        item.setType("Coffee");
        Assertions.assertEquals("Coffee", item.getType());
    }

    @Test
    public void testPrice () {
        ItemInterface item = new Fillings("Fillings", 0.12, "FILB", "Bacon");
        Assertions.assertEquals(0.12, item.getPrice());
        item.setPrice(0.50);
        Assertions.assertEquals(0.50, item.getPrice());
    }

    @Test
    public void testSKU () {
        ItemInterface item = new Fillings("Fillings", 0.12, "FILB", "Bacon");
        Assertions.assertEquals("FILB", item.getSku());
        item.setSku("FILP");
        Assertions.assertEquals("FILP", item.getSku());

    }
    @Test
    public void testVariant () {
        ItemInterface item = new Fillings("Fillings", 0.12, "FILB", "Bacon");
        Assertions.assertEquals("Bacon", item.getVariant());
        item.setVariant("Jalapeno");
        Assertions.assertEquals("Jalapeno", item.getVariant());
    }


}
