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
        Assertions.assertEquals("Plain Bagel removed from basket.", basket.removeItem("BGLP", false));
        Assertions.assertEquals(2, basket.getBasketSize());
        Assertions.assertEquals("2 Onion Bagels removed from basket.", basket.removeItem("BGLO", true));
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

    @Test
    public void totalCostItemsInBasket(){
        Basket basket = new Basket();

        Assertions.assertEquals("Your basket is empty.", basket.sumOrder());

        basket.addItem("BGLO", 2);
        basket.addItem("BGLP", 1);
        basket.addItem("FILE", 1);
        basket.addItem("COFC", 1);


        Assertions.assertEquals("The sum of your order is: 2.78", basket.sumOrder());
        basket.addItem("COFC", 1);
        Assertions.assertEquals("The sum of your order is: 4.07", basket.sumOrder());

    }

    @Test
    public void getItemCost(){
        Menu menu = new Menu();
        Assertions.assertEquals("0.49", menu.getItemCost("BGLS"));
    }

    // Extension 1 requirements tests

    @Test
    public void bagelDiscount(){
        Basket basket = new Basket();
        basket.setMaxBasketSize(25);

        basket.addItem("BGLO", 5);
        basket.addItem("FILB", 1);
        Assertions.assertEquals("The sum of your order is: 2.57", basket.sumOrderDiscount());

        basket.addItem("BGLO", 1);
        Assertions.assertEquals("The sum of your order is: 2.61", basket.sumOrderDiscount());

        basket.addItem("BGLP", 3);
        Assertions.assertEquals("The sum of your order is: 3.78", basket.sumOrderDiscount());

        basket.addItem("BGLS", 3);
        Assertions.assertEquals("The sum of your order is: 4.11", basket.sumOrderDiscount());

        basket.addItem("BGLE", 1);
        Assertions.assertEquals("The sum of your order is: 4.60", basket.sumOrderDiscount());

        basket.addItem("BGLE", 11);
        Assertions.assertEquals("The sum of your order is: 8.10", basket.sumOrderDiscount());

    }

    @Test
    public void bagelCoffeeDiscount(){
        Basket basket = new Basket();

        basket.addItem("BGLO", 2);
        basket.addItem("COFW", 1);

        Assertions.assertEquals("The sum of your order is: 1.74", basket.sumOrderDiscount());
        basket.removeItem("BGLO", false);

        Assertions.assertEquals("The sum of your order is: 1.25", basket.sumOrderDiscount());


    }

    @Test
    public void allDiscounts(){
        Basket basket = new Basket();
        basket.setMaxBasketSize(25);

        basket.addItem("BGLS", 6);
        basket.addItem("BGLO", 13);
        basket.addItem("FILC", 1);
        basket.addItem("COFL", 1);

        Assertions.assertEquals("The sum of your order is: 7.85", basket.sumOrderDiscount());
    }
}
