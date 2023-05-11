package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FillingTest {
    @Test
    void getCostShouldBe5() {
        Filling filling = new Filling();

        Assertions.assertEquals(5.0, filling.getCost());
    }

    @Test
    void getTypeShouldBeNormal() {
        Filling filling = new Filling();

        Assertions.assertEquals(FILLINGTYPE.NORMAL, filling.getType());
    }
}
