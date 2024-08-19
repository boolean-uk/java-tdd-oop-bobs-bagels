package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestOrderManager {

    @Test
    public void testOrderExists(){
        TestOrderManager tom = new TestOrderManager();
    }

    @Test
    public void testCreateItem(){
        TestOrderManager tom = new TestOrderManager();
        Assertions.assertTrue(tom.getItems().isEmpty());
        tom.createItem();
        Assertions.assertTrue(!tom.getItems().isEmpty());
    }

}
