package com.booleanuk.core.model.item;

import com.booleanuk.core.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {
    @Test
    public void canAddFillingToBagel() {
        Bagel bagel = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        Filling filling = new Filling("FILC", 0.12, "Filling", "Cheese");
        Assertions.assertEquals(0, bagel.getFilling().size());
        Assertions.assertTrue(bagel.addFillingToBagel(filling));
        Assertions.assertEquals(1, bagel.getFilling().size());
    }
}
