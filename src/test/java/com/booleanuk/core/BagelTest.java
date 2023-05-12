package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {
    @Test
    void getTypeShouldBeNormal() {
        Bagel bagel = new Bagel(BAGELTYPE.ONION);

        Assertions.assertEquals(BAGELTYPE.ONION, bagel.getType());
    }
}
