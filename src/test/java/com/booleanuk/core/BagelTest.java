package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagelTest {
    @Test
    public void testCalculateCost() {
        Bagel bagel = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Assertions.assertEquals(0.61f, bagel.calculateCost(), 0.001);
    }
}