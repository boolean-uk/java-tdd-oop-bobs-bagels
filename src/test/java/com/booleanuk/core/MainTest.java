package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    Store store = new Store();
    Order order = new Order();
    MainTest() {

    }

    @Test
    public void testUpdateCapacity() {
        store.updateCapacity(1);
        Assertions.assertEquals(11, store.getCapacity());
    }

    @Test
    public void testAddBagel() {
        order.addProduct(store.bagels1);
        Assertions.assertEquals(order.basket.size(), 1);
        order.addProduct(store.fillings7);
        Assertions.assertNotEquals(order.basket.size(), 2);

    }
}
