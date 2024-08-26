package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BagelTest {
    @Test
    public void testCalculateCost() {
        Bagel bagel = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Assertions.assertEquals(0.61f, bagel.calculateCost(), 0.001);
    }

    @Test
    public void testAddSeveralFillings() {
        ArrayList<Triple<String, String, Float>> fillings = new ArrayList<>() {{
            add(Controller.prices.get("FILB"));
            add(Controller.prices.get("FILC"));
        }};
        Bagel bagel = new Bagel(Controller.prices.get("BGLO"), fillings);
        Assertions.assertEquals(0.73f, bagel.calculateCost(), 0.001);
    }
}