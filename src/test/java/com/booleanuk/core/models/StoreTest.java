package com.booleanuk.core.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class StoreTest {

    @Test
    public void canInitializeStoreAndGetItemsFromFile() throws FileNotFoundException, URISyntaxException {
        Store bobsBagels = new Store("Bob's Bagels");
        Assertions.assertEquals("Bob's Bagels", bobsBagels.getName());
        // inventory db file has 14 different items at this time
        Assertions.assertEquals(14, bobsBagels.getInventory().size());
    }
}
