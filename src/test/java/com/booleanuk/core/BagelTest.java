package com.booleanuk.core;

import com.booleanuk.core.products.bagels.Bagel;
import com.booleanuk.core.products.bagels.OnionBagel;
import com.booleanuk.core.products.bagels.PlainBagel;
import com.booleanuk.core.products.fillings.SmokedSalmonFilling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {

    public BagelTest() {

    }

    @Test
    public void testCreateOnionBagel() {
        Bagel b = new OnionBagel();

        Assertions.assertEquals(0.49, b.getPrice());
    }

    @Test
    public void testCreatePlainBabel() {
        Bagel b = new PlainBagel();

        Assertions.assertEquals(0.39, b.getPrice());
    }

    @Test
    public void testCreateBagelAndAddFilling() {
        Bagel bagel = new OnionBagel();
        Bagel b = new OnionBagel();
        bagel.setFilling(new SmokedSalmonFilling());

        Assertions.assertEquals("FILS", bagel.getFilling().getSKU());
    }

    @Test
    public void testCreateSesameBagel() {
        Bagel b = new SesameBagel();

        Assertions.assertEquals(0.49, b.getPrice());
        Assertions.assertEquals("BGLS", b.getSKU());
    }

    @Test
    public void testCreateEverythingBagel() {
        Bagel b = new EverythingBagel();

        Assertions.assertEquals(0.49, b.getPrice());
        Assertions.assertEquals("BGLE", b.getSKU());
    }

}
