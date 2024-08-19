package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    public void testCreateOrder() {
        Order order = new Order();
        Assertions.assertEquals(0, order.getTotalSum());
    }

    @Test
    public void testAddProduct() {
        Order order = new Order();
        Product product = new Product("SKU", 10, "Variant");
        order.addProduct(product);
        Assertions.assertEquals(10, order.getTotalSum());

        Product product2 = new Product("SKU2", 20, "Variant2");
        order.addProduct(product2);
        Assertions.assertEquals(30, order.getTotalSum());
    }
}
