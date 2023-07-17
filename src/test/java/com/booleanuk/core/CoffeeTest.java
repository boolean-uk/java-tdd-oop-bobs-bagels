package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static com.booleanuk.core.SKU.BGLP;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoffeeTest {
    @Test
    public void testCreatingCoffeeWithWrongSKU() {
        assertThrows(IllegalArgumentException.class, () -> new Coffee(BGLP));
    }
}
