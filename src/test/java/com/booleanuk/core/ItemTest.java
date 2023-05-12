package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {
    @Test
    void getCostShouldBe049() {
        Bagel bagel = new Bagel(BAGELTYPE.ONION);

        Assertions.assertEquals(0.49, bagel.getCost());
    }

}
