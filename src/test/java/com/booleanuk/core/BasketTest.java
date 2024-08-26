package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    // Core requirements tests

    // User story 1
    @Test
    public void addBagelToBasket(){
        Basket basket = new Basket();

        Assertions.assertEquals("2 Onion Bagel added to basket.", basket.addItem("BGLO", 2));
        Assertions.assertEquals("1 Plain Bagel added to basket.", basket.addItem("BGLP", 1));

        Assertions.assertEquals(2, basket.getBasketItems().get("BGLO"));
        Assertions.assertEquals(1, basket.getBasketItems().get("BGLP"));
        Assertions.assertEquals(3, basket.getBasketSize());
    }

    // User story 2
    @Test
    public void removeBagelFromBasket(){
        Basket basket = new Basket();

        basket.addItem("BGLO", 2);
        basket.addItem("BGLP", 1);
        Assertions.assertEquals("1 Plain Bagel removed from basket.", basket.removeItem("BGLP", false));
        Assertions.assertEquals(2, basket.getBasketSize());
        Assertions.assertEquals("2 Onion Bagel removed from basket.", basket.removeItem("BGLO", true));
        Assertions.assertEquals(0, basket.getBasketSize());
    }

    // User story 3
    @Test
    public void addBagelFullBasket(){
        Basket basket = new Basket();
        basket.addItem("BGLO", 15);
        Assertions.assertEquals("Basket is full.", basket.addItem("BGLP", 1));

    }

    // User story 4
    @Test
    public void changeBasketCapacity(){
        Basket basket = new Basket();

        Assertions.assertTrue(basket.setMaxBasketSize(10));
        Assertions.assertEquals(10, basket.getMaxBasketSize());
        Assertions.assertFalse(basket.setMaxBasketSize(-2));
    }

    // User story 5
    @Test
    public void removeItemNotInBasket(){
        Basket basket = new Basket();

        Assertions.assertEquals("This item does not exist in your basket.", basket.removeItem("COFB", false));
    }

    // User story 6
    @Test
    public void totalCostItemsInBasket(){
        Basket basket = new Basket();
        Receipt receipt = new NormalReceipt();
        CashRegister register = new CashRegister(basket, receipt);

        Assertions.assertEquals("Your basket is empty.", register.sumOrder());

        basket.addItem("BGLO", 2);
        basket.addItem("BGLP", 1);
        basket.addItem("FILE", 1);

        Assertions.assertEquals("The sum of your order is: 1.49", register.sumOrder());

    }

    // User story 7
    @Test
    public void getBagelCost(){
        Menu menu = new Menu();
        Assertions.assertEquals("0.49", menu.getItemCost("BGLS"));
    }

    // User story 8
    @Test
    public void addFilling(){
        Basket basket = new Basket();

        Assertions.assertEquals("2 Cheese Filling added to basket.", basket.addItem("FILC", 2));
        Assertions.assertEquals("1 Bacon Filling added to basket.", basket.addItem("FILB", 1));

        Assertions.assertEquals(2, basket.getBasketItems().get("FILC"));
        Assertions.assertEquals(1, basket.getBasketItems().get("FILB"));
        Assertions.assertEquals(3, basket.getBasketSize());
    }

    // User story 9
    @Test
    public void getFillingCost(){
        Menu menu = new Menu();
        Assertions.assertEquals("0.12", menu.getItemCost("FILC"));
    }

    // User story 10
    @Test
    public void addItemNotInInventory(){
        Basket basket = new Basket();

        Assertions.assertEquals("This item is not on the menu.", basket.addItem("Not a bagel.", 2));
    }

}
