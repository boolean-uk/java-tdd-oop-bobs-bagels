package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    public void testCreateOrder() {
        Store store = new Store("Bob's Bagels");
        Order order = new Order(store);
        Assertions.assertEquals(0, order.getTotalSum());
    }

    @Test
    public void testAddProduct() {
        Store store = new Store("Bob's Bagels");
        Order order = new Order(store);
        Product product = store.getInventory().getProduct("BGLO");
        order.addProduct(product);
        Assertions.assertEquals(product.getPrice(), order.getTotalSum());

        Product product2 = store.getInventory().getProduct("BGLP");
        order.addProduct(product2);
        Assertions.assertEquals(product2.getPrice() + product.getPrice(), order.getTotalSum());
    }

    @Test
    public void testGetBasket() {
        Store store = new Store("Bob's Bagels");
        Order order = new Order(store);
        Product product = store.getInventory().getProduct("BGLO");
        order.addProduct(product);
        Assertions.assertEquals(1, order.getBasket().size());
    }

    @Test
    public void testAddSameProductTwice() {
        Store store = new Store("Bob's Bagels");
        Order order = new Order(store);
        Product product = store.getInventory().getProduct("BGLO");
        order.addProduct(product);
        order.addProduct(product);
        Assertions.assertEquals(product.getPrice() * 2, order.getTotalSum());
        Assertions.assertEquals(2, order.getBasket().size());
    }

    @Test
    public void testAddBagelWithFilling() {
        Store store = new Store("Bob's Bagels");
        Order order = new Order(store);
        Bagel bagel = (Bagel) store.getInventory().getProduct("BGLO");
        Product filling = store.getInventory().getProduct("FILB");
        int bagelPlusFillingPrice = bagel.getPrice() + filling.getPrice();

        bagel.addFilling((Filling) filling);
        order.addProduct(bagel);

        Assertions.assertEquals(bagelPlusFillingPrice, order.getTotalSum());

        order.addProduct(filling);
        Assertions.assertEquals(bagelPlusFillingPrice + filling.getPrice(), order.getTotalSum());

        order.removeProduct(bagel);
        Assertions.assertEquals(filling.getPrice(), order.getTotalSum());
    }

    @Test
    public void testBasketIsFull() {
        Store store = new Store("Bob's Bagels");
        Order order = new Order(store);
        Product product = store.getInventory().getProduct("BGLO");
        addProductsToOrder(order, product, 25);
        Assertions.assertFalse(order.addProduct(product));
    }

    @Test
    public void testRemoveProduct() {
        Store store = new Store("Bob's Bagels");
        Order order = new Order(store);
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
    }

    @Test
    public void testIncrementBasketCapacity() {
        Store store = new Store("Bob's Bagels");
        Order order = new Order(store);
        order.incrementBasketCapacity();
        Assertions.assertEquals(30, order.getMaxBasketCapacity());
    }

    @Test
    public void testGetProductPrice() {
        Store store = new Store("Bob's Bagels");
        Order order = new Order(store);
        Product product = store.getInventory().getProduct("BGLO");

        Assertions.assertEquals(product.getPrice(), order.getProductPrice("BGLO"));

        Assertions.assertEquals(-1, order.getProductPrice(""));
        Assertions.assertEquals(-1, order.getProductPrice("INVALID"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> order.getProductPrice(null));
    }

    @Test
    public void testMultiBuyDiscount6Bagels() {
        Store store = new Store("Bob's Bagels");
        Product bagelO = store.getInventory().getProduct("BGLO");
        Product bagelP = store.getInventory().getProduct("BGLP");
        Order order = new Order(store);
        addProductsToOrder(order, bagelO, 1);
        addProductsToOrder(order, bagelP, 6);

        Assertions.assertEquals(249 + bagelO.getPrice(), order.getTotalSum());

        order.removeProduct(bagelP);
        Assertions.assertEquals(249, order.getTotalSum());

        order.removeProduct(bagelO);
        Assertions.assertEquals(bagelP.getPrice() * 5, order.getTotalSum());

    }

    @Test
    public void testMultiBuyDiscount12Bagels() {
        Store store = new Store("Bob's Bagels");
        Product bagelO = store.getInventory().getProduct("BGLO");
        Product bagelP = store.getInventory().getProduct("BGLP");
        Order order = new Order(store);
        addProductsToOrder(order, bagelO, 6);
        addProductsToOrder(order, bagelP, 6);
        Assertions.assertEquals(399, order.getTotalSum());

        order.addProduct(bagelO);
        Assertions.assertEquals(399 + bagelO.getPrice(), order.getTotalSum());

        order.removeProduct(bagelO);
        Assertions.assertEquals(399, order.getTotalSum());
    }

    @Test
    public void testMultiBuyDiscount12To6Bagels() {
        Store store = new Store("Bob's Bagels");
        Product bagelO = store.getInventory().getProduct("BGLO");
        Product bagelP = store.getInventory().getProduct("BGLP");
        Order order = new Order(store);
        addProductsToOrder(order, bagelO, 6);
        addProductsToOrder(order, bagelP, 6);
        Assertions.assertEquals(399, order.getTotalSum());


        order.removeProduct(bagelO);
        Assertions.assertEquals(249 + 5 * bagelO.getPrice(), order.getTotalSum());
    }

    @Test
    public void testMixingMultiBuyDiscounts() {
        Store store = new Store("Bob's Bagels");
        Product bagelO = store.getInventory().getProduct("BGLO");
        Product bagelP = store.getInventory().getProduct("BGLP");
        Order order = new Order(store);
        addProductsToOrder(order, bagelO, 12);
        addProductsToOrder(order, bagelP, 6);
        Assertions.assertEquals(399 + 249, order.getTotalSum());

        order.removeProduct(bagelO);
        Assertions.assertEquals(399 + 5 * bagelO.getPrice() , order.getTotalSum());
    }

    @Test
    public void testCoffeeBagelDiscount() {
        Store store = new Store("Bob's Bagels");
        Product bagelO = store.getInventory().getProduct("BGLO");
        Product coffee = store.getInventory().getProduct("COFB");
        Order order = new Order(store);
        addProductsToOrder(order, bagelO, 1);
        addProductsToOrder(order, coffee, 1);
        Assertions.assertEquals(125, order.getTotalSum());

        addProductsToOrder(order, bagelO, 1);
        Assertions.assertEquals(125 + bagelO.getPrice(), order.getTotalSum());
        addProductsToOrder(order, coffee, 1);
        Assertions.assertEquals(250, order.getTotalSum());

    }

    @Test
    public void testCoffeeBagelDiscountWithSixBagelDiscount() {
        Store store = new Store("Bob's Bagels");
        Product bagelO = store.getInventory().getProduct("BGLO");
        Product coffee = store.getInventory().getProduct("COFB");
        Order order = new Order(store);
        addProductsToOrder(order, bagelO, 6);
        addProductsToOrder(order, coffee, 1);
        Assertions.assertEquals(249 + coffee.getPrice(), order.getTotalSum());

        addProductsToOrder(order, bagelO, 1);
        Assertions.assertEquals(249 + 125, order.getTotalSum());
    }

    @Test
    public void testCoffeeBagelDiscountWithTwelveBagelDiscount() {
        Store store = new Store("Bob's Bagels");
        Product bagelO = store.getInventory().getProduct("BGLO");
        Product coffee = store.getInventory().getProduct("COFB");
        Order order = new Order(store);
        addProductsToOrder(order, bagelO, 12);
        addProductsToOrder(order, coffee, 1);
        Assertions.assertEquals(399 + coffee.getPrice(), order.getTotalSum());

        addProductsToOrder(order, bagelO, 1);
        Assertions.assertEquals(399 + 125, order.getTotalSum());
    }

    @Test
    public void testCoffeeBagelDiscountWithTwelveAndSixBagelDiscount() {
        Store store = new Store("Bob's Bagels");
        Product bagelO = store.getInventory().getProduct("BGLO");
        Product coffee = store.getInventory().getProduct("COFB");
        Order order = new Order(store);
        addProductsToOrder(order, bagelO, 12);
        addProductsToOrder(order, coffee, 1);
        Assertions.assertEquals(399 + coffee.getPrice(), order.getTotalSum());

        addProductsToOrder(order, bagelO, 6);
        Assertions.assertEquals(399 + 249 + coffee.getPrice(), order.getTotalSum());

        addProductsToOrder(order, bagelO, 1);
        Assertions.assertEquals(399 + 249 + 125, order.getTotalSum());
    }

    @Test
    public void testBagelDiscountWithFilling() {
        Store store = new Store("Bob's Bagels");
        Bagel bagelO = (Bagel) store.getInventory().getProduct("BGLO");
        Order order = new Order(store);
        Product filling = store.getInventory().getProduct("FILB");

        bagelO.addFilling((Filling) filling);
        addProductsToOrder(order, bagelO, 6);
        Assertions.assertEquals(249 + filling.getPrice() * 6, order.getTotalSum());

        addProductsToOrder(order, filling, 1);
        Assertions.assertEquals(249 + filling.getPrice() * 7, order.getTotalSum());
    }

    // Helper method to add products to an order
    private void addProductsToOrder(Order order, Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            order.addProduct(product);
        }
    }
}
