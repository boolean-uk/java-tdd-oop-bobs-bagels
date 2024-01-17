package com.booleanuk.core.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class ItemTest {
    private static final String bagelPlainSKU = "BGLP";

    @Test
    public void canGetPriceOfItem() throws FileNotFoundException {
        Store bobsTest = new Store("TesT Store");
        Item itemToGetPriceOf = bobsTest.getItemBySKU(bagelPlainSKU);
        Assertions.assertEquals(0.39, itemToGetPriceOf.getPrice());
    }
}
