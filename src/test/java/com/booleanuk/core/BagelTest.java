package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {
    @Test
    void getCostShouldBe5() {
        Bagel bagel = new Bagel();

        Assertions.assertEquals(5.0, bagel.getCost());
    }

    @Test
    void getTypeShouldBeNormal() {
        Bagel bagel = new Bagel();

        Assertions.assertEquals(BAGELTYPE.NORMAL, bagel.getType());
    }
}
