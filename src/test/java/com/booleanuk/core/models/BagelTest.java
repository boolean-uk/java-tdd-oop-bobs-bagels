package com.booleanuk.core.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {

    @Test
    public void addFillingsTest() {
        Bagel bagel = new Bagel("Sesame", 0.49, "BGLS");
        Filling fill1 = new Filling("Bacon", "FILB");
        Filling fill2 = new Filling("Egg", "FILE");
        Filling[] fills = {fill1, fill2};

        bagel.addFillings(fills);
        Assertions.assertEquals(2,bagel.fillings.size());
    }
}
