package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class TestOrderManager {

    @Test
    public void testOrderExists(){
        OrderManager om = new OrderManager();
    }

    @Test
    public void testCreateItem(){
        OrderManager om = new OrderManager();
        Assertions.assertTrue(om.getItems().isEmpty());
        om.createItem();
        Assertions.assertTrue(!om.getItems().isEmpty());
    }

}
