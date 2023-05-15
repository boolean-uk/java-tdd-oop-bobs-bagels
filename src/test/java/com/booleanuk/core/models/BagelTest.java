package com.booleanuk.core.models;

import com.booleanuk.core.Invetory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class BagelTest {

    @Test
    void setFillingsTest() {
        Invetory invetory = new Invetory();
        Bagel bagel = new Bagel("Onion", 0.49, "BGLO");
        Filling fill1 = new Filling("Bacon",0.12, "FILB");
        Filling fillError = new Filling("Random",0.0, "WRONG");

        Assertions.assertTrue(bagel.setFillings(new ArrayList<>(Arrays.asList(fill1)), invetory));
        Assertions.assertFalse(bagel.setFillings(new ArrayList<>(Arrays.asList(fillError)), invetory));

    }
}
