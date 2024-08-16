package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    Store store = new Store();
    MainTest() {

    }

    @Test
    public void testUpdateCapacity() {
        store.updateCapacity(1);
        Assertions.assertEquals(11, store.getCapacity());
    }



}
