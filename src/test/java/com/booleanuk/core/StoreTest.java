package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StoreTest {

    @Test
    public void testCreateStore() {
        Store store = new Store("Bob's Bagels");
        Assertions.assertNotNull(store);
        Assertions.assertEquals("Bob's Bagels", store.getName());
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Store(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Store(""));
        Assertions.assertNotNull(store.getInventory().getProduct("BGLO"));
    }

    @Test
    public void testAddOrder() {
        Store store = new Store("Bob's Bagels");
        Order order = new Order(store);
        store.addOrder(order);

        Assertions.assertEquals(1, store.getOrders().size());
    }



}
