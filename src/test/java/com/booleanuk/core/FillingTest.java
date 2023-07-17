package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FillingTest {
    @Test
    public void priceGetterTest() {
        Item filling1 = new Item(FillingType.FILB);
        Item filling2 = new Item(FillingType.FILX);
        Assertions.assertEquals(0.12, filling1.getPrice());
        Assertions.assertEquals(0.12, filling2.getPrice());
    }
}
