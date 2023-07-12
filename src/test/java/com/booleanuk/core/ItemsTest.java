package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemsTest {

    @Test
    void testGetTypeBagel(){
        Bagel bagel = new Bagel(BAGELTYPE.PLAIN);
        Assertions.assertEquals(BAGELTYPE.PLAIN,bagel.getType());
    }
    @Test
    void testGetTypeCoffee(){
        Coffee coffee = new Coffee(COFFEETYPE.BLACK);
        Assertions.assertEquals(COFFEETYPE.BLACK,coffee.getType());
    }
    @Test
    void testGetTypeFilling(){
        Filling filling = new Filling(FILLINGTYPE.BACON);
        Assertions.assertEquals(FILLINGTYPE.BACON,filling.getType());
    }
    @Test
    void testGetPriceItem(){
        Bagel bagel = new Bagel(BAGELTYPE.PLAIN);
        Coffee coffee = new Coffee(COFFEETYPE.BLACK);
        Filling filling = new Filling(FILLINGTYPE.BACON);

        Assertions.assertEquals(0.39,bagel.getPrice());
        Assertions.assertEquals(0.99,coffee.getPrice());
        Assertions.assertEquals(0.12,filling.getPrice());

    }
    @Test
    void testFillingInBagel(){
        Bagel bagel = new Bagel(BAGELTYPE.PLAIN);
        Filling filling = new Filling(FILLINGTYPE.BACON);
        bagel.setFillings(filling);
        Filling bagelFirstFilling= bagel.getFillings().get(0);
        Assertions.assertEquals(FILLINGTYPE.BACON,bagelFirstFilling.getType());

    }
}
