package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReceiptTest {

    @Test
    public void testCreateReceipt() {
        Order order = new Order();
        Receipt receipt = new Receipt(order);
        Assertions.assertNotNull(receipt);
    }

    @Test
    public void testReceiptOrder() {
        Order order = new Order();
        Receipt receipt = new Receipt(order);
        Assertions.assertEquals(order, receipt.getOrder());
    }

    @Test
    public void testReceiptTotal() {
        Order order = new Order();
        Store store = new Store("Bob's Bagels");
        Product product = store.getInventory().getProduct("BGLO");
        order.addProduct(product);
        Receipt receipt = new Receipt(order);
        Assertions.assertEquals(product.getPrice(), receipt.getOrder().getTotalSum());
    }

    @Test
    public void testPrintReceipt() {
        Order order = new Order();
        Store store = new Store("Bob's Bagels");
        Product product = store.getInventory().getProduct("BGLO");
        order.addProduct(product);
        Receipt receipt = new Receipt(order);
        Assertions.assertTrue(receipt.printReceipt());

        order.removeProduct(product);
        Assertions.assertFalse(receipt.printReceipt());
    }
}
