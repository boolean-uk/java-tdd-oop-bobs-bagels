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
        Store store = new Store("Bob's Bagels");
        Product product = store.getInventory().getProduct("BGLO");
        order.addProduct(product);
        Assertions.assertEquals(product.getPrice(), order.getTotalSum());

        Product product2 = store.getInventory().getProduct("BGLP");
        order.addProduct(product2);
        Assertions.assertEquals(product2.getPrice() + product.getPrice(), order.getTotalSum());
    }

    @Test
    public void testGetBasket() {
        Order order = new Order();
        Store store = new Store("Bob's Bagels");
        Product product = store.getInventory().getProduct("BGLO");
        order.addProduct(product);
        Assertions.assertEquals(1, order.getBasket().size());
        Assertions.assertEquals(1, order.getBasket().get(product.getSKU()));
    }

    @Test
    public void testAddSameProductTwice() {
        Order order = new Order();
        Store store = new Store("Bob's Bagels");
        Product product = store.getInventory().getProduct("BGLO");
        order.addProduct(product);
        order.addProduct(product);
        Assertions.assertEquals(product.getPrice() * 2, order.getTotalSum());
        Assertions.assertEquals(1, order.getBasket().size());
        Assertions.assertEquals(2, order.getBasket().get(product.getSKU()));
    }

    @Test
    public void testBasketIsFull() {
        Order order = new Order();
        Store store = new Store("Bob's Bagels");
        Product product = store.getInventory().getProduct("BGLO");
        addProductsToOrder(order, product, 25);
        Assertions.assertFalse(order.addProduct(product));
    }

    @Test
    public void testRemoveProduct() {
        Order order = new Order();
        Store store = new Store("Bob's Bagels");
        Product product = store.getInventory().getProduct("BGLO");
        Product product2 = store.getInventory().getProduct("BGLP");
        order.addProduct(product);
        Assertions.assertTrue(order.removeProduct(product));
        Assertions.assertEquals(0, order.getTotalSum());
        Assertions.assertEquals(0, order.getBasket().size());

        order.addProduct(product);
        order.addProduct(product);
        order.addProduct(product2);
        order.removeProduct(product);
        Assertions.assertEquals(product.getPrice() + product2.getPrice(), order.getTotalSum());
        Assertions.assertEquals(2, order.getBasket().size());
        Assertions.assertEquals(1, order.getBasket().get(product.getSKU()));
    }

    @Test
    public void testIncrementBasketCapacity() {
        Order order = new Order();
        order.incrementBasketCapacity();
        Assertions.assertEquals(30, order.getMaxBasketCapacity());
    }

    // test multi buy discount 6 bagels for 249
    @Test
    public void testMultiBuyDiscount6Bagels() {
        Store store = new Store("Bob's Bagels");
        Product bagelO = store.getInventory().getProduct("BGLO");
        Product bagelP = store.getInventory().getProduct("BGLP");
        Order order = new Order();
        addProductsToOrder(order, bagelO, 1);
        addProductsToOrder(order, bagelP, 6);

        Assertions.assertEquals(249 + bagelO.getPrice(), order.getTotalSum());

        order.removeProduct(bagelP);
        Assertions.assertEquals(249, order.getTotalSum());

        order.removeProduct(bagelO);
        Assertions.assertEquals(bagelP.getPrice() * 5, order.getTotalSum());

    }

    // test multi buy discount 12 bagels for 399
    @Test
    public void testMultiBuyDiscount12Bagels() {
        Store store = new Store("Bob's Bagels");
        Product bagelO = store.getInventory().getProduct("BGLO");
        Product bagelP = store.getInventory().getProduct("BGLP");
        Order order = new Order();
        addProductsToOrder(order, bagelO, 6);
        addProductsToOrder(order, bagelP, 6);
        Assertions.assertEquals(399, order.getTotalSum());

        order.addProduct(bagelO);
        Assertions.assertEquals(399 + bagelO.getPrice(), order.getTotalSum());

        order.removeProduct(bagelO);
        Assertions.assertEquals(399, order.getTotalSum());
    }

    // test multi buy discount going from 12 bagels to 6 bagels discount
    @Test
    public void testMultiBuyDiscount12To6Bagels() {
        Store store = new Store("Bob's Bagels");
        Product bagelO = store.getInventory().getProduct("BGLO");
        Product bagelP = store.getInventory().getProduct("BGLP");
        Order order = new Order();
        addProductsToOrder(order, bagelO, 6);
        addProductsToOrder(order, bagelP, 6);
        Assertions.assertEquals(399, order.getTotalSum());


        order.removeProduct(bagelO);
        Assertions.assertEquals(249 + 5 * bagelO.getPrice(), order.getTotalSum());
    }

    // Test for mixing multi buy discounts 12 and 6 bagels
    @Test
    public void testMixingMultiBuyDiscounts() {
        Store store = new Store("Bob's Bagels");
        Product bagelO = store.getInventory().getProduct("BGLO");
        Product bagelP = store.getInventory().getProduct("BGLP");
        Order order = new Order();
        addProductsToOrder(order, bagelO, 12);
        addProductsToOrder(order, bagelP, 6);
        Assertions.assertEquals(399 + 249, order.getTotalSum());
    }

    // Helper method to add products to an order
    private void addProductsToOrder(Order order, Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            order.addProduct(product);
        }
    }
}
