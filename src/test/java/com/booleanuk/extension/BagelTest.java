package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {

    @Test
    public void testBagelCreation() {
        Bagel bagel = new Bagel("BGLP", 0.39, "Plain");
        Assertions.assertEquals("BGLP",bagel.getId());
        Assertions.assertEquals(0.39, bagel.getPrice());
        Assertions.assertEquals("Plain", bagel.getDescription());
        Assertions.assertInstanceOf(Bagel.class, bagel);
    }

    @Test
    public void testFillingAttachment() {
        Bagel bagel = new Bagel("BGLP", 0.39, "Plain");
        Filling filling1 = new Filling("FILB", 0.12, "Bacon");
        bagel.attachFilling(filling1); //add first filling
        Assertions.assertEquals(filling1, bagel.getAllFillings().getFirst());
        bagel.attachFilling(filling1); // add second filling
        bagel.attachFilling(filling1); // add third filling
        Assertions.assertFalse(bagel.attachFilling(filling1)); //adding the fourth filling should fail
    }
}
