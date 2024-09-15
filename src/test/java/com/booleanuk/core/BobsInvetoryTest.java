package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BobsInvetoryTest {
    Bagel bagel = new Bagel(BAGELTYPE.PLAIN);
    Coffee coffee = new Coffee(COFFEETYPE.BLACK);
    Filling filling = new Filling(FILLINGTYPE.BACON);


    @Test
    void testGetNoItemsInInvetory() {
        Assertions.assertFalse(BobsInvetory.isBagelInInvetory(bagel.getType()));
        Assertions.assertFalse(BobsInvetory.isCoffeeInInvetory(coffee.getType()));
        Assertions.assertFalse(BobsInvetory.isFillingInInvetory(filling.getType()));
    }

    @Test
    void testAddItemsInInvetory() {
        BobsInvetory.add(bagel);
        BobsInvetory.add(coffee);
        BobsInvetory.add(filling);
        Assertions.assertTrue(BobsInvetory.isBagelInInvetory(bagel.getType()));
        Assertions.assertTrue(BobsInvetory.isCoffeeInInvetory(coffee.getType()));
        Assertions.assertTrue(BobsInvetory.isFillingInInvetory(filling.getType()));
    }

    @Test
    void testResetItemsInInvetory() {
        BobsInvetory.add(bagel);
        Assertions.assertTrue(BobsInvetory.isBagelInInvetory(bagel.getType()));
        BobsInvetory.resetBagelsAndCoffee();
        Assertions.assertFalse(BobsInvetory.isBagelInInvetory(bagel.getType()));
    }


}
