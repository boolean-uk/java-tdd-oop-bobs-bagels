package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemFactoryTest {

    @Test
    public void testBagelCreation() {
        ItemFactory factory = new ItemFactory();
        Item item = factory.createItem("BGLP");
        Assertions.assertInstanceOf(Bagel.class, item); //Item should be a bagel because "BGLP" is a bagel SKU

    }
    @Test
    public void testFillingCreation() {
        ItemFactory factory = new ItemFactory();
        Item item = factory.createItem("FILB");
        Assertions.assertInstanceOf(Filling.class, item); //Item should be a filling because "FILB" is a filling SKU
    }

    @Test
    public void testCoffeeCreation() {
        ItemFactory factory = new ItemFactory();
        Item item = factory.createItem("COFB");
        Assertions.assertInstanceOf(Coffee.class, item); //Item should be a coffee because "COFB" is a coffee SKU
    }

    @Test
    public void testNullCreation() {
        ItemFactory factory = new ItemFactory();
        Item item = factory.createItem("XXXX");
        Assertions.assertNull(item); //Item should be a null because "XXXX" is not a valid SKU
    }

}
