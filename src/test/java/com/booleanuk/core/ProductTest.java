package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ProductTest {
    @Test
    public void testBagelList(){
        Bagel bagels = new Bagel();
        Assertions.assertEquals("[[BGLO, Bagel, Onion, 0.49], " +
                "[BGLP, Bagel, Plain, 0.39], [BGLE, Bagel, Everything, 0.49], " +
                "[BLGS, Bagel, Sesame, 0.49]]",Arrays.deepToString(bagels.bagels));
    }
    @Test
    public void testCoffeeList(){
        Coffee coffee = new Coffee();
        Assertions.assertEquals("[[COFB, Coffee, Black, 0.99], " +
                "[COFW, Coffee, White, 1.99], " +
                "[COFC, Coffee, Cappuccino, 1.29], " +
                "[COFL, Coffee, Latte, 1.29]]",Arrays.deepToString(coffee.coffee));
    }
    @Test
    public void testFillingList(){
        Filling filling = new Filling();
        Assertions.assertEquals("[[FILB, Filling, Bacon, 0.12], " +
                "[FILE, Filling, Egg, 0.12], " +
                "[FILC, Filling, Cheese, 0.12], " +
                "[FILX, Filling, Cream Cheese, 0.12], " +
                "[FILS, Filling, Smoked Salmon, 0.12], " +
                "[FILH, Filling, Ham, 0.12]]",Arrays.deepToString(filling.filling));
    }
}
