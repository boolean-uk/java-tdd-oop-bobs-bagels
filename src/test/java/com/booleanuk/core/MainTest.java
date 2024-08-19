package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class MainTest {

    Store store = new Store();
    Order order = new Order();

    MainTest() {

    }

    @Test
    public void testUpdateCapacity() {
        store.updateCapacity(1);
        Assertions.assertEquals(7, store.getCapacity());
    }

    @Test
    public void testAddBagel() {
        order.addProduct(store.getBagels1());
        Assertions.assertEquals(1, order.sizeOfBasket());
        Assertions.assertTrue(order.containsKeyBasket(store.getBagels1().getSKU()));
        order.addProduct(store.getFillings7()); // not in inventory
        Assertions.assertNotEquals(2, order.sizeOfBasket());
        Assertions.assertFalse(order.containsKeyBasket(store.getFillings7().getSKU()));

    }

    @Test
    public void testMaxCapacity() {
        order.addProduct(store.getBagels1());
        order.addProduct(store.getBagels2());
        order.addProduct(store.getBagels3());
        order.addProduct(store.getBagels4());
        order.addProduct(store.getCoffee1());
        order.addProduct(store.getCoffee2());
        Assertions.assertFalse(order.addProduct(store.getCoffee4()));
    }

    @Test
    public void testAddFilling() {
        Assertions.assertFalse(order.addProduct(store.getFillings1()));
        order.addProduct(store.getBagels1());
        Assertions.assertTrue(order.addProduct(store.getFillings1()));
        Assertions.assertTrue(order.containsKeyBasket(store.getFillings1().getSKU()));
    }

    @Test
    public void testGetPriceProduct() {
        Assertions.assertEquals(0.99, order.getPriceProduct(store.getCoffee1()));
    }

    @Test
    public void testRemoveBagel() {
        order.addProduct(store.getBagels1());
        order.addProduct(store.getCoffee1());
        order.removeProduct(store.getBagels1());
        Assertions.assertEquals(1, order.sizeOfBasket());
        Assertions.assertThrows(NoSuchElementException.class, () -> order.removeProduct(store.getBagels1()));
    }

    @Test
    public void testTotalCost() {
        order.addProduct(store.getBagels1());
        order.addProduct(store.getFillings1());
        order.addProduct(store.getCoffee1());
        Assertions.assertEquals(1.6, order.getTotalPrice());

    }


}
