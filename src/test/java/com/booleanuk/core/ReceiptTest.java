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
}
