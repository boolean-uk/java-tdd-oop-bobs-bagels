package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ProductTest {
    @Test
    public void testBagelList(){
        Bagel bagels = new Bagel();
        System.out.println(Arrays.deepToString(bagels.bagels));
    }
    @Test
    public void testCoffeeList(){
        Coffee coffee = new Coffee();
        System.out.println(Arrays.deepToString(coffee.coffee));
    }
    @Test
    public void testFillingList(){
        Filling filling = new Filling();
        System.out.println(Arrays.deepToString(filling.filling));
    }
}
