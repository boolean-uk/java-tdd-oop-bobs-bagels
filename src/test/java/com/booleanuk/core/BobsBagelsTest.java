package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BobsBagelsTest {

    @Test
    public void addItemToBasketReturnTrue() {
        Basket basket = new Basket();

        boolean result = basket.addItem("BGLO");

        Assertions.assertTrue(result);
    }


    @Test
    public void removeItemFromBasket() {
        Basket basket = new Basket();

        basket.addItem("BGLO");
        boolean result = basket.removeItem("BGLO");

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
        Inventory inventory = new Inventory();
        Order order = new Order(inventory);


        basket.addItem("BGLP");
        basket.addItem("BGLP");
        double total = order.getTotalCost(basket.getItemList());

        Assertions.assertEquals(0.78, total, 0.0001);
    }
    @Test
    public void testTotalCostFiveItems(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Order order = new Order(inventory);


        basket.addItem("BGLP");
        basket.addItem("BGLS");
        basket.addItem("COFB");
        basket.addItem("FILB");
        double total = order.getTotalCost(basket.getItemList());

        Assertions.assertEquals(1.99, total, 0.0001);
    }

    @Test
    public void testDisplayingMenu() {
        Order order = new Order();
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);

        System.out.println(inventory.getFullInventoryList().toString());

        Assertions.assertNotNull(inventory);
    }

    @Test
    public void testSysOutPrint() {
        Order order = new Order();
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);

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

    @Test
    public void testGetItemPrice(){

        Order order = new Order();
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);

        inventory.getInventoryPriceList();

        Assertions.assertEquals(0.49, inventory.getItemPrice("BGLO"));
        Assertions.assertEquals(0.39, inventory.getItemPrice("BGLP"));
        Assertions.assertEquals(1.19, inventory.getItemPrice("COFW"));
        Assertions.assertEquals(1.29, inventory.getItemPrice("COFL"));
        Assertions.assertEquals(0.12, inventory.getItemPrice("FILC"));
        Assertions.assertEquals(0.12, inventory.getItemPrice("FILH"));
    }

    @Test
    public void testAddItemNotInInventory() {

        Order order = new Order();
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);

        Assertions.assertFalse(basket.addItem("banana"));
        Assertions.assertTrue(basket.addItem("BGLO"));
        Assertions.assertTrue(basket.addItem("COFC"));
        Assertions.assertFalse(basket.addItem("COFQ"));
    }

    @Test
    public void testReceiptExistsAndCharacters() {
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Order order = new Order(inventory);

        basket.changeBasketCapacity(6);

        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLO");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("COFB");
        basket.addItem("COFB");
        basket.addItem("COFB");
        basket.addItem("FILB");

        String receipt = order.generateReceipt(basket.getItemList());
        System.out.println(receipt);
        Assertions.assertNotNull(receipt);
        Assertions.assertTrue(receipt.length() > 50);

    }

    @Test
    public void testReceiptWithNoItems() {
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Order order = new Order(inventory);

        String receipt = order.generateReceipt(basket.getItemList());
//        System.out.println(receipt);
        Assertions.assertNotNull(receipt);
        Assertions.assertFalse(receipt.length() < 150);
        Assertions.assertFalse(receipt.length() > 155);


    }
//    @Test
//    public void testDiscounts() {
//        Basket basket = new Basket();
//        Inventory inventory = new Inventory();
//        Order order = new Order(inventory);
//
//        basket.addItem("BGLP");
//        basket.addItem("BGLP");
//    }

}