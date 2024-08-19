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
        order.addProduct(store.bagels1);
        Assertions.assertEquals(1, order.basket.size());
        Assertions.assertTrue(order.basket.containsKey(store.bagels1.getSKU()));
        order.addProduct(store.fillings7); // not in inventory
        Assertions.assertNotEquals(2, order.basket.size());
        Assertions.assertFalse(order.basket.containsKey(store.fillings7.getSKU()));

    }

    @Test
    public void testMaxCapacity() {
        order.addProduct(store.bagels1);
        order.addProduct(store.bagels2);
        order.addProduct(store.bagels3);
        order.addProduct(store.bagels4);
        order.addProduct(store.coffee1);
        order.addProduct(store.coffee2);
        Assertions.assertFalse(order.addProduct(store.coffee3));
    }

    @Test
    public void testAddFilling() {
        Assertions.assertFalse(order.addProduct(store.fillings1));
        order.addProduct(store.bagels1);
        Assertions.assertTrue(order.addProduct(store.fillings1));
        Assertions.assertTrue(order.basket.containsKey(store.fillings1.getSKU()));
    }

    @Test
    public void testGetPriceProduct() {
        Assertions.assertEquals(0.99, order.getPriceProduct(store.coffee1));
    }

    @Test
    public void testRemoveBagel() {
        order.addProduct(store.bagels1);
        order.addProduct(store.coffee1);
        order.removeProduct(store.bagels1);
        Assertions.assertEquals(1, order.basket.size());
        Assertions.assertThrows(NoSuchElementException.class, () -> order.removeProduct(store.bagels3));
    }

    @Test
    public void testTotalCost() {
        order.addProduct(store.bagels1);
        order.addProduct(store.fillings1);
        order.addProduct(store.coffee1);

        Assertions.assertEquals(1.6, order.getTotalPrice());

    }


}
