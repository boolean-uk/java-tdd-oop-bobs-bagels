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
    public void testPrintReceipt() {
        Store store = new Store("Bob's Bagels");
        Order order = new Order(store);
        Product product = store.getInventory().getProduct("BGLO");
        order.addProduct(product);
        Receipt receipt = new Receipt(order);
        Assertions.assertTrue(receipt.printReceipt());

        order.removeProduct(product);
        Assertions.assertFalse(receipt.printReceipt());
    }
}
