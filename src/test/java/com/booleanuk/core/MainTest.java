package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class MainTest {

    private Bagels bagels1;
    private Bagels bagels2;
    private Bagels bagels3;
    private Bagels bagels4;

    private Coffee coffee1;
    private Coffee coffee2;
    private Coffee coffee3;
    private Coffee coffee4;

    private Fillings fillings1;
    private Fillings fillings2;
    private Fillings fillings3;
    private Fillings fillings4;
    private Fillings fillings5;
    private Fillings fillings6;
    private Fillings fillings7;

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
        order.addProduct(bagels1);
        bagels1.addFilling(fillings1);
        order.addProduct(coffee1);
        Assertions.assertEquals(1.97, order.getTotalPrice());

    }

    @Test
    public void testAddFilling() {
        bagels1.addFilling(fillings1);
        Assertions.assertEquals(1, bagels1.getFillings().size());
        Assertions.assertEquals(fillings1, bagels1.getFillings().getFirst());

    }

    @Test
    public void testRemoveFilling() {
        bagels1.addFilling(fillings1);
        bagels1.addFilling(fillings2);


        bagels1.removeFilling(fillings2);
        Assertions.assertEquals(1, bagels1.getFillings().size());
        Assertions.assertFalse(bagels1.getFillings().contains(fillings2));


        bagels1.removeFilling(fillings2);
        Assertions.assertEquals(1, bagels1.getFillings().size());
    }

    /*

    Just for checking my basket

    */
    @Test
    public void testPrintBasket() {
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);

        order.addProduct(bagels2);
        bagels2.addFilling(fillings1);
        bagels2.addFilling(fillings1);
        order.addProduct(bagels3);
        bagels3.addFilling(fillings2);
        order.printBasket();
        bagels2.printFillings();
    }

    @Test
    public void testDiscountEighteenBagels() {
        order.addProduct(bagels1); // 6
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels2); //6
        order.addProduct(bagels2);
        order.addProduct(bagels2);
        order.addProduct(bagels2);
        order.addProduct(bagels2);
        order.addProduct(bagels2);
        order.addProduct(bagels3); // 6
        order.addProduct(bagels3);
        order.addProduct(bagels3);
        order.addProduct(bagels3);
        order.addProduct(bagels3);
        order.addProduct(bagels3);
        Assertions.assertEquals(6.48, order.getTotalPrice());

    }
}

