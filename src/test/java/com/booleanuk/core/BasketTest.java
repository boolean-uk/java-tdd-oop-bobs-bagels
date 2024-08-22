package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    // Core requirements tests
    @Test
    public void addBagelToBasket(){
        Basket basket = new Basket();

        Assertions.assertEquals("2 Onion Bagel added to basket.", basket.addItem("BGLO", 2));
        Assertions.assertEquals("1 Plain Bagel added to basket.", basket.addItem("BGLP", 1));

        Assertions.assertEquals(2, basket.getBasketItems().get("BGLO"));
        Assertions.assertEquals(1, basket.getBasketItems().get("BGLP"));
        Assertions.assertEquals(3, basket.getBasketSize());
    }

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

    @Test
    public void addBagelFullBasket(){
        Basket basket = new Basket();
        basket.addItem("BGLO", 15);
        Assertions.assertEquals("Basket is full.", basket.addItem("BGLP", 1));

    }

    @Test
    public void changeBasketCapacity(){
        Basket basket = new Basket();

        Assertions.assertTrue(basket.setMaxBasketSize(10));
        Assertions.assertEquals(10, basket.getMaxBasketSize());
        Assertions.assertFalse(basket.setMaxBasketSize(-2));
    }

    @Test
    public void removeItemNotInBasket(){
        Basket basket = new Basket();

        Assertions.assertEquals("This item does not exist in your basket.", basket.removeItem("COFB", false));
    }

    /*@Test
    public void totalCostItemsInBasket(){
        Basket basket = new Basket();
        CashRegister register = new CashRegister(basket);

        Assertions.assertEquals("Your basket is empty.", register.sumOrder());

        basket.addItem("BGLO", 2);
        basket.addItem("BGLP", 1);
        basket.addItem("FILE", 1);
        basket.addItem("COFC", 1);


        Assertions.assertEquals("The sum of your order is: 2.78", register.sumOrder());
        basket.addItem("COFC", 1);
        Assertions.assertEquals("The sum of your order is: 4.07", register.sumOrder());

    }*/

    @Test
    public void getItemCost(){
        Menu menu = new Menu();
        Assertions.assertEquals("0.49", menu.getItemCost("BGLS"));
    }


    // Extension 1 requirements tests

    @Test
    public void bagelDiscount(){
        Basket basket = new Basket();
        CashRegister register = new CashRegister(basket);
        basket.setMaxBasketSize(25);
        basket.addItem("BGLO", 18);
        basket.addItem("BGLP", 1);
        basket.addItem("COFB",1);

        Assertions.assertEquals("The sum of your order is: 7.73", register.sumOrder());



    }

    @Test
    public void bagelCoffeeDiscount(){
        Basket basket = new Basket();
        CashRegister register = new CashRegister(basket);

        basket.addItem("BGLO", 2);
        basket.addItem("COFW", 1);

        Assertions.assertEquals("The sum of your order is: 1.74", register.sumOrder());
    }

    @Test
    public void allDiscounts(){
        Basket basket = new Basket();
        CashRegister register = new CashRegister(basket);
        basket.setMaxBasketSize(25);

        basket.addItem("BGLS", 6);
        basket.addItem("BGLO", 13);
        basket.addItem("FILC", 1);
        basket.addItem("COFL", 1);

        Assertions.assertEquals("The sum of your order is: 7.85", register.sumOrder());
    }
}
