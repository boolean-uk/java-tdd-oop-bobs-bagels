package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemFactoryTest {

    @Test
    public void testItemCreation() {
        ItemFactory factory = new ItemFactory();
        Item item = factory.createItem("BGLP");
        Assertions.assertInstanceOf(Bagel.class, item); //Item should be a bagel because "BGLP" is a bagel SKU

    }
}
