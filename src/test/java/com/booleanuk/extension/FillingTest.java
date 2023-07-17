package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import static com.booleanuk.extension.SKU.COFB;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FillingTest {
    @Test
    public void testCreatingFillingWithWrongSKU() {
        assertThrows(IllegalArgumentException.class, () -> new Filling(COFB));
    }
}
