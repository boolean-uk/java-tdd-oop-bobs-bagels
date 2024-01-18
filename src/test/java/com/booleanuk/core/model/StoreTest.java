package com.booleanuk.core.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class StoreTest {

    @Test
    public void canInitializeStoreAndGetItemsFromFile() throws FileNotFoundException {
        Store bobsBagels = new Store("Bob's Bagels");
        Assertions.assertEquals("Bob's Bagels", bobsBagels.getName());
        // inventory db file has 14 different items at this time
        Assertions.assertEquals(14, bobsBagels.getInventory().size());
    }
}
