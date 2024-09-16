package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BargainTest {

    @Test
    public void bargain6BagelsTest() {
        Bargain bargain = Bargain.bargain6Bagels();

        assertEquals(6, bargain.packSize());
        assertEquals(249, bargain.packCost());
    }

    @Test
    public void bargain12BagelsTest() {
        Bargain bargain = Bargain.bargain12Bagels();

        assertEquals(12, bargain.packSize());
        assertEquals(399, bargain.packCost());
    }
}
