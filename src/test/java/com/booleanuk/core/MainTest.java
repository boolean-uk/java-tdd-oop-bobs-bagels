package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    MainTest() {
        Store store = new Store();
    }

    @Test
    public void testUpdateCapacity() {
        Assertions.assertEquals(11, store.updateCapacity(1));
    }

}
