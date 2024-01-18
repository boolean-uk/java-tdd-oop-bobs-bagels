package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BobsBagelsTest {

    @Test
    public void addItemToBasketReturnTrue() {
        Basket basket = new Basket();

        boolean result = basket.addItem("plain");

        Assertions.assertTrue(result);
    }


    @Test
    public void removeItemFromBasket() {
        Basket basket = new Basket();

        basket.addItem("plain");
        boolean result = basket.removeItem("plain");

        Assertions.assertTrue(result);
    }

    @Test
    public void removeItemNotInBasket() {
        Basket basket = new Basket();

        boolean result = basket.removeItem("bread");

        Assertions.assertFalse(result);
    }

    @Test
    public void checkIfBasketIsFull() {
        Basket basket = new Basket();

        basket.addItem("plain");
        basket.addItem("chocolate");
        basket.addItem("honey");
        basket.addItem("salmon");

        Assertions.assertFalse(basket.addItem("cheese"));


    }

    @Test
    public void checkIfBasketSizeCanIncrease() {
        Basket basket = new Basket();

        basket.changeBasketCapacity(5);

        Assertions.assertEquals(9, basket.getBasketCapacity());
    }

    @Test
    public void checkIfBasketSizeCanDecrease() {
        Basket basket = new Basket();

        basket.changeBasketCapacity(-2);

        Assertions.assertEquals(2, basket.getBasketCapacity());
    }

    @Test
    public void checkIfBasketSizeHandlesNegative() {
        Basket basket = new Basket();

        basket.changeBasketCapacity(-10);

        Assertions.assertEquals(4, basket.getBasketCapacity());
    }

    @Test
    public void testTotalCostTwoItems(){
        Basket basket = new Basket();
        Order order = new Order();

        basket.addItem("BGLP");
        basket.addItem("BGLP");
        double total = order.getTotalCost(basket.getItemList());

        Assertions.assertEquals(0.78, total, 0.0001);
    }
    @Test
    public void testTotalCostFiveItems(){
        Basket basket = new Basket();
        Order order = new Order();


        basket.addItem("BGLP");
        basket.addItem("BGLS");
        basket.addItem("COFB");
        basket.addItem("FILB");
        double total = order.getTotalCost(basket.getItemList());

        Assertions.assertEquals(1.99, total, 0.0001);
    }

    @Test
    public void testDisplayingMenu() {
        Basket basket = new Basket();
        Order order = new Order();
        Inventory inventory = new Inventory();

        System.out.println(inventory.getFullInventoryList().toString());

        Assertions.assertNotNull(inventory);
    }

    @Test
    public void testSysOutPrint() {
        Basket basket = new Basket();
        Order order = new Order();
        Inventory inventory = new Inventory();

        inventory.printMenu();

        Assertions.assertNotNull(inventory);
    }

//    @Test
//    public void testDisplayingMenu() {
//        Basket basket = new Basket();
//        Order order = new Order();
//        Inventory inventory = new Inventory();
//
////        System.out.println(inventory.getInventoryPriceList());
//
//        Assertions.assertNotNull(inventory.getInventoryPriceList());
//    }

}