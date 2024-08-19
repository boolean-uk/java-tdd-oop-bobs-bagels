package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class MainTest {

    private Product bagels1;
    private Product bagels2;
    private Product bagels3;
    private Product bagels4;

    private Product coffee1;
    private Product coffee2;
    private Product coffee3;
    private Product coffee4;

    private Product fillings1;
    private Product fillings2;
    private Product fillings3;
    private Product fillings4;
    private Product fillings5;
    private Product fillings6;
    private Product fillings7;

    private Store store;
    private Order order;

    MainTest() {
        store = new Store();
        order = new Order(store);
        bagels1 = new Bagels("BGLO", 0.49, "Onion");
        bagels2 = new Bagels("BGLP", 0.39, "Plain");
        bagels3 = new Bagels("BGLE", 0.49, "Everything");
        bagels4 = new Bagels("BGLS", 0.49, "Sesame");

        coffee1 = new Coffee("COFB", 0.99, "Black");
        coffee2 = new Coffee("COFW", 1.19, "White");
        coffee3 = new Coffee("COFC", 1.29, "Cappuccino");
        coffee4 = new Coffee("COFL", 1.29, "Latte");

        fillings1 = new Fillings("FILB", 0.12, "Bacon");
        fillings2 = new Fillings("FILE", 0.12, "Egg");
        fillings3 = new Fillings("FILC", 0.12, "Cheese");
        fillings4 = new Fillings("FILX", 0.12, "Cream Cheese");
        fillings5 = new Fillings("FILS", 0.12, "Smoked Salmon");
        fillings6 = new Fillings("FILH", 0.12, "Ham");

        fillings7 = new Fillings("FILP", 0.12, "Pepperoni");

        store.addToInventory(bagels1);
        store.addToInventory(bagels2);
        store.addToInventory(bagels3);
        store.addToInventory(bagels4);

        store.addToInventory(coffee1);
        store.addToInventory(coffee2);
        store.addToInventory(coffee3);
        store.addToInventory(coffee4);

        store.addToInventory(fillings1);
        store.addToInventory(fillings2);
        store.addToInventory(fillings3);
        store.addToInventory(fillings4);
        store.addToInventory(fillings5);
        store.addToInventory(fillings6);
    }


    @Test
    public void testUpdateCapacity() {
        store.updateCapacity(1);
        Assertions.assertEquals(7, store.getCapacity());
    }

    @Test
    public void testAddBagel() {
        order.addProduct(bagels1);
        Assertions.assertEquals(1, order.sizeOfBasket());
        Assertions.assertTrue(order.containsKeyBasket(bagels1.getSKU()));
        order.addProduct(fillings7); // not in inventory
        Assertions.assertNotEquals(2, order.sizeOfBasket());
        Assertions.assertFalse(order.containsKeyBasket(fillings7.getSKU()));

    }

    @Test
    public void testMaxCapacity() {
        order.addProduct(bagels1);
        order.addProduct(bagels2);
        order.addProduct(bagels3);
        order.addProduct(bagels4);
        order.addProduct(coffee1);
        order.addProduct(coffee2);
        Assertions.assertFalse(order.addProduct(coffee3));
    }

    @Test
    public void testAddFilling() {
        Assertions.assertFalse(order.addProduct(fillings1));
        order.addProduct(bagels1);
        Assertions.assertTrue(order.addProduct(fillings1));
        Assertions.assertTrue(order.containsKeyBasket(fillings1.getSKU()));
    }

    @Test
    public void testGetPriceProduct() {
        Assertions.assertEquals(0.99, order.getPriceProduct(coffee1));
    }

    @Test
    public void testRemoveBagel() {
        order.addProduct(bagels1);
        order.addProduct(coffee1);
        order.removeProduct(bagels1);
        Assertions.assertEquals(1, order.sizeOfBasket());
        Assertions.assertThrows(NoSuchElementException.class, () -> order.removeProduct(bagels1));
    }

    @Test
    public void testTotalCost() {
        order.addProduct(bagels1);
        order.addProduct(fillings1);
        order.addProduct(coffee1);
        Assertions.assertEquals(1.6, order.getTotalPrice());

    }


}
