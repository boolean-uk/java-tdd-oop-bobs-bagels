package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReceiptTest {

    // test to make sure that the receipt is created
    @Test
    public void testCreateReceipt() {
        Order order = new Order();
        Receipt receipt = new Receipt(order);
        Assertions.assertNotNull(receipt);
    }
}
