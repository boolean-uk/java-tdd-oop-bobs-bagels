package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReceiptTest {

    @Test
    public void testCreateReceipt() {
        Store store = new Store("Bob's Bagels");
        Order order = new Order(store);
        Receipt receipt = new Receipt(order);
        Assertions.assertNotNull(receipt);
    }

    @Test
    public void testReceiptOrder() {
        Store store = new Store("Bob's Bagels");
        Order order = new Order(store);
        Receipt receipt = new Receipt(order);
        Assertions.assertEquals(order, receipt.getOrder());
    }

    @Test
    public void testReceiptTotal() {
        Store store = new Store("Bob's Bagels");
        Order order = new Order(store);
        Product product = store.getInventory().getProduct("BGLO");
        order.addProduct(product);
        Receipt receipt = new Receipt(order);
        Assertions.assertEquals(product.getPrice(), receipt.getOrder().getTotalSum());
    }

    @Test
    public void testPrintReceiptWithoutDiscounts() {
        Store store = new Store("Bob's Bagels");
        Order order = new Order(store);
        Bagel bagel1 = (Bagel) store.getInventory().getProduct("BGLO");
        Bagel bagel2 = (Bagel) store.getInventory().getProduct("BGLO");
        Filling filling1 = (Filling) store.getInventory().getProduct("FILB");
        Filling filling2 = (Filling) store.getInventory().getProduct("FILE");

        bagel1.addFilling(filling1);
        bagel1.addFilling(filling2);

        addProductsToOrder(order, bagel1, 2);
        addProductsToOrder(order, bagel2, 3);

        Receipt receipt = new Receipt(order);
        Assertions.assertTrue(receipt.printReceipt());
    }

    @Test
    public void testPrintReceiptWithDiscounts() {
        Store store = new Store("Bob's Bagels");
        Order order = new Order(store);
        Bagel bagel1 = (Bagel) store.getInventory().getProduct("BGLO");
        Bagel bagel2 = (Bagel) store.getInventory().getProduct("BGLO");
        Product coffee = store.getInventory().getProduct("COFB");
        Filling filling1 = (Filling) store.getInventory().getProduct("FILB");
        Filling filling2 = (Filling) store.getInventory().getProduct("FILE");

        bagel1.addFilling(filling1);
        bagel1.addFilling(filling2);

        addProductsToOrder(order, bagel1, 12);
        addProductsToOrder(order, bagel2, 7);
        addProductsToOrder(order, coffee, 2);


        Receipt receipt = new Receipt(order);
        Assertions.assertTrue(receipt.printReceipt());
    }

    // Helper method to add products to an order
    private void addProductsToOrder(Order order, Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            order.addProduct(product);
        }
    }
}
