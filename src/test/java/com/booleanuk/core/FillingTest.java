package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static com.booleanuk.core.SKU.COFB;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FillingTest {
    @Test
    public void testCreatingFillingWithWrongSKU() {
        assertThrows(IllegalArgumentException.class, () -> new Filling(COFB));
    }
}
