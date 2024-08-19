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

    @Test
    public void testGetBasket() {
        Order order = new Order();
        Product product = new Product("SKU", 10, "Variant");
        Assertions.assertTrue(order.addProduct(product));
        Assertions.assertEquals(1, order.getBasket().size());
        Assertions.assertEquals(1, order.getBasket().get(product.getSKU()));
    }

    @Test
    public void testAddSameProductTwice() {
        Order order = new Order();
        Product product = new Product("SKU", 10, "Variant");
        order.addProduct(product);
        order.addProduct(product);
        Assertions.assertEquals(20, order.getTotalSum());
        Assertions.assertEquals(1, order.getBasket().size());
        Assertions.assertEquals(2, order.getBasket().get(product.getSKU()));
    }

    @Test
    public void testBasketIsFull() {
        Order order = new Order();
        Product product = new Product("SKU", 10, "Variant");
        for (int i = 0; i < 20; i++) {
            order.addProduct(product);
        }
       Assertions.assertFalse(order.addProduct(product));
    }

    @Test
    public void testRemoveProduct() {
        Order order = new Order();
        Product product = new Product("SKU", 10, "Variant");
        Product product2 = new Product("SKU2", 20, "Variant2");
        order.addProduct(product);
        order.removeProduct(product);
        Assertions.assertEquals(0, order.getTotalSum());
        Assertions.assertEquals(0, order.getBasket().size());

        order.addProduct(product);
        order.addProduct(product);
        order.addProduct(product2);
        order.removeProduct(product);
        Assertions.assertEquals(30, order.getTotalSum());
        Assertions.assertEquals(2, order.getBasket().size());
        Assertions.assertEquals(1, order.getBasket().get(product.getSKU()));
    }

    // test ìncrementBasketCapacity()
    @Test
    public void testIncrementBasketCapacity() {
        Order order = new Order();
        order.incrementBasketCapacity();
        Assertions.assertEquals(25, order.getMaxBasketCapacity());
    }
}
