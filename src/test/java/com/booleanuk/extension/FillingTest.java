package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FillingTest {

    @Test
    public void testFillingCreation() {
        Filling filling = new Filling("FILB", 0.12, "Bacon");
        Assertions.assertEquals("FILB",filling.getId());
        Assertions.assertEquals(0.12, filling.getPrice());
        Assertions.assertEquals("Bacon", filling.getDescription());
        Assertions.assertInstanceOf(Filling.class, filling);
    }
}
