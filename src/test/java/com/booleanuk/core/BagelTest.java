package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {
    ItemFactory itemFactory;
    @Test
    public void createBagel() {
        Bagel bagel = new Bagel("BGLO");

        Assertions.assertEquals(0.49f, bagel.getPrice(), 0.001);
    }

    @Test
    public void checkTypeBagelTest() {
        Bagel bagel = ItemFactory.bagelFactory("BGLO");


        Assertions.assertEquals("Bagel", bagel.getType());
    }

    @Test
    public void checkNameBagelTest() {
        Bagel bagel = ItemFactory.bagelFactory("BGLO");

        Assertions.assertEquals("Onion", bagel.getName());
    }

    @Test
    public void addFillingToBagel() {
        Bagel bagel1 = ItemFactory.bagelFactory("BGLE");
        Bagel bagelWithFilling = ItemFactory.bagelWithFillingFactory("BGLO", "FILB");
        Filling filling = new Filling("FILX");
        Bagel bagel = new Bagel("BGLE");
        bagel.addFilling(filling);

        Assertions.assertEquals("Everything", bagel1.getName());
        Assertions.assertEquals("FILX", bagel.getFilling().getSKU());
        Assertions.assertEquals("FILB", bagelWithFilling.getFilling().getSKU());
    }
}
