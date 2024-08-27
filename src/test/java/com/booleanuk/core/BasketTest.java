package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasketTest {

    @Test
    public void addItemTest(){

        Basket basket = new Basket(2);
        Assertions.assertTrue(basket.addItem("BGLP"));

    }

    @Test
    public void removeItem(){

        Basket basket = new Basket(1);
        basket.addItem("BGLP");

        Assertions.assertTrue(basket.removeItem("BGLP"));
        Assertions.assertTrue(basket.getItems().isEmpty());

    }

    @Test
    public void getTotalCostTest(){

        Basket basket = new Basket(3);

        basket.addItem("BGLP");
        basket.addItem("COFL");
        basket.addItem("FILB");

        Assertions.assertEquals(1.80, basket.getTotalCost(), 0.00001);

    }


    @Test
    public void isFullTest(){

        Basket basket = new Basket(2);

        Assertions.assertTrue(basket.addItem("BGLP"));
        Assertions.assertTrue(basket.addItem("COFL"));

        Assertions.assertTrue(basket.isFull());

        Assertions.assertFalse(basket.addItem("FILB"));

    }

    @Test
    public void nonExistent(){

        Basket basket = new Basket(2);

        Assertions.assertTrue(basket.addItem("BGLP"));
        Assertions.assertTrue(basket.addItem("COFL"));

        Assertions.assertTrue(basket.isFull());
        Assertions.assertFalse(basket.addItem("FILB"));

    }

    @Test
    public void inventoryTest(){

        Basket basket = new Basket(3);

        Assertions.assertTrue(basket.addItem("BGLP"));
        Assertions.assertTrue(basket.addItem("FILB"));
        Assertions.assertFalse(basket.addItem("FILA"));

        Assertions.assertEquals(2, basket.getItems().size());

    }

    @Test
    public void discountCostTest() {

        Basket basket = new Basket(50);

        for (int i = 0; i < 24; i++) {

            basket.addItem("BGLP");
        }
        basket.addItem("FILE");

        Assertions.assertEquals(8.10, basket.discountPrice(), 0.00001);

    }

    @Test
    public void coffeeAndBagelDiscountTest(){

        Basket basket = new Basket(5);

        basket.addItem("COFB");
        basket.addItem("BGLP");
        basket.addItem("COFB");
        basket.addItem("BGLP");
        basket.addItem("BGLP");

        Assertions.assertEquals(2.89, basket.coffeeAndBagelDiscount(), 0.00001);

    }

    @Test
    public void printReceiptTest() {

        Basket basket = new Basket(50);
        basket.addItem("COFB");
        basket.addItem("BGLE");
        basket.addItem("BGLO");
        basket.addItem("COFB");
        basket.addItem("BGLP");
        basket.addItem("BGLO");

        String receipt = basket.printReceipt();

        System.out.println(receipt);

    }

}

