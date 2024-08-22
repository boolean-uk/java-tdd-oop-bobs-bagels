package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class MainTest {

    private Bagels bagels1;
    private Bagels bagels2;
    private Bagels bagels3;
    private Bagels bagels4;
    private Bagels bagels5;

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

    private Store store;
    private Order order;
    private Receipt receipt;
    private int capacity = 20;

    MainTest() {
        store = new Store(capacity);
        order = new Order(store);
        receipt = new Receipt(order, store);
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

        bagels5 = new Bagels("BGLQ", 0.39, "Cheese"); // not in inventory

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
        Assertions.assertEquals(21, store.getCapacity());
    }

    @Test
    public void testAddBagel() {
        order.addProduct(bagels1);
        Assertions.assertEquals(1, order.sizeOfBasket());
        Assertions.assertTrue(order.containsKeyBasket(bagels1.getSKU()));
        order.addProduct(bagels5); // not in inventory
        Assertions.assertNotEquals(2, order.sizeOfBasket());
        Assertions.assertFalse(order.containsKeyBasket(bagels5.getSKU()));
    }

    @Test
    public void testMaxCapacity() {
        order.addProduct(bagels1);
        order.addProduct(bagels2);
        order.addProduct(bagels3);
        order.addProduct(bagels4);
        order.addProduct(coffee1);
        order.addProduct(coffee2);
        order.addProduct(bagels1);
        order.addProduct(bagels2);
        order.addProduct(bagels3);
        order.addProduct(bagels4);
        order.addProduct(coffee1);
        order.addProduct(coffee2);
        order.addProduct(bagels1);
        order.addProduct(bagels2);
        order.addProduct(bagels3);
        order.addProduct(bagels4);
        order.addProduct(coffee1);
        order.addProduct(coffee2);
        order.addProduct(bagels3);
        order.addProduct(bagels3);
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
        order.addProduct(fillings1);
        order.addProduct(fillings1);
        order.addProduct(coffee1);
        Assertions.assertEquals(1.98, order.getTotalPrice());

    }

    @Test
    public void testAddFilling() {
        bagels1.addFilling(fillings1);
        Assertions.assertEquals(1, bagels1.getFillings().size());
        //Assertions.assertEquals(fillings1, bagels1.getFillings().getFirst());

    }

    @Test
    public void testRemoveFilling() {
        bagels1.addFilling(fillings1);
        bagels1.addFilling(fillings2);


        bagels1.removeFilling(fillings2);
        Assertions.assertEquals(1, bagels1.getFillings().size());
        //Assertions.assertFalse(bagels1.getFillings().contains(fillings2));


        bagels1.removeFilling(fillings2);
        Assertions.assertEquals(1, bagels1.getFillings().size());
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

    @Test
    public void testDiscountCoffeeAndBagels() {
        order.addProduct(bagels1);
        order.addProduct(bagels2);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels4);
        order.addProduct(bagels1);

        order.addProduct(bagels2);
        order.addProduct(bagels3);
        order.addProduct(bagels4);
        order.addProduct(bagels1);
        order.addProduct(bagels2);
        order.addProduct(bagels3);

        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);

        order.addProduct(fillings1);

        order.addProduct(bagels2);
        order.addProduct(coffee1);

        Assertions.assertEquals(7.85, order.getTotalPrice());
    }

    @Test
    public void testDiscountCoffee() {
        order.addProduct(bagels1);
        order.addProduct(coffee1);
        order.addProduct(bagels2);
        order.addProduct(coffee2);
        order.addProduct(bagels2);
        order.addProduct(coffee1);
        order.addProduct(bagels4);
        order.addProduct(coffee3);

        Assertions.assertEquals(5, order.getTotalPrice());
    }

    @Test
    public void testPrintReceipt() {
        order.addProduct(bagels1);
        order.addProduct(bagels2);
        order.addProduct(bagels3);
        order.addProduct(bagels4);
        order.addProduct(fillings1);
        order.addProduct(fillings1);
        order.addProduct(bagels1);
        order.addProduct(bagels2);// 6
        order.addProduct(bagels3);
        order.addProduct(bagels4);
        order.addProduct(bagels1);
        order.addProduct(bagels2);
        order.addProduct(bagels3);
        order.addProduct(bagels4); //6
        order.addProduct(bagels1);
        order.addProduct(bagels2);
        order.addProduct(bagels3);
        order.addProduct(bagels4);
        order.addProduct(bagels1);
        order.addProduct(bagels2); //6
        order.addProduct(bagels3);
        order.addProduct(coffee1);
        order.addProduct(fillings1);
        order.addProduct(fillings1);
        order.addProduct(fillings2);
        order.addProduct(coffee1);
        order.addProduct(coffee1);

        receipt.printReceipt();
    }

    @Test
    public void testPrintReceiptDiscount() {
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);

        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);

        order.addProduct(bagels1);
        order.addProduct(coffee1);

        receipt.printReceipt();
    }

    @Test
    public void testBigDiscount() {
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        Assertions.assertEquals(1.89,order.bigDiscount());
    }

    @Test
    public void testSmallDiscount() {
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        order.addProduct(bagels1);
        Assertions.assertEquals(0.45,order.smallDiscount());
    }

    @Test
    public void testCoffeAndBagel() {
        order.addProduct(bagels1);
        order.addProduct(coffee1);
        Assertions.assertEquals(0.23,order.coffeeAndBagelDiscount());
    }
}

