package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BagelTest {

    Bagel bagel;
    Filling filling;

    @BeforeEach
    void beforeEach() {
        bagel = new Bagel(12);
        filling = new Filling(3);
    }

    @Test
    void shouldSetBagelFillings() {
        Assertions.assertEquals(0, bagel.getFillings().size());
        bagel.setFillings(List.of(filling));
        Assertions.assertEquals(1, bagel.getFillings().size());
    }

    @Test
    void shouldReturnPriceOfBagelAndFillings() {
        Assertions.assertEquals(12, bagel.getPrice());
        bagel.setFillings(List.of(filling));
        Assertions.assertEquals(15, bagel.getPrice());
    }
}
