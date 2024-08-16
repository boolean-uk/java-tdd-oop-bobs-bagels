package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    public void testCreateOrder() {
        Order order = new Order();
        Assertions.assertEquals(0, order.getTotalSum());
    }
}
