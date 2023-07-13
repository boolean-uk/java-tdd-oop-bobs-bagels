package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelsTest {

    @Test
    public void testType () {
        ItemInterface item = new Bagels("Bagel", 0.29, "BGLG", "Gluten-free");
        Assertions.assertEquals("Bagel", item.getType());
        item.setType("Coffee");
        Assertions.assertEquals("Coffee", item.getType());
    }

    @Test
    public void testPrice () {
        ItemInterface item = new Bagels("Bagel", 0.29, "BGLG", "Gluten-free");
        Assertions.assertEquals(0.29, item.getPrice());
        item.setPrice(0.50);
        Assertions.assertEquals(0.50, item.getPrice());
    }

    @Test
    public void testSKU () {
        ItemInterface item = new Bagels("Bagel", 0.29, "BGLG", "Gluten-free");
        Assertions.assertEquals("BGLG", item.getSku());
        item.setSku("BGBD");
        Assertions.assertEquals("BGBD", item.getSku());

    }
    @Test
    public void testVariant () {
        ItemInterface item = new Bagels("Bagel", 0.29, "BGLG", "Gluten-free");
        Assertions.assertEquals("Gluten-free", item.getVariant());
        item.setVariant("Low GI");
        Assertions.assertEquals("Low GI", item.getVariant());
    }


}
