package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FillingTest {

    @Test
    public void createFillingTest() {
        Filling filling = new Filling("FILH");

        Assertions.assertEquals("FILH", filling.getSKU());
    }
}
