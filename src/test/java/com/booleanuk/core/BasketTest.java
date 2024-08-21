package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    public void addBagelToBasket(){
        Basket basket = new Basket();

        Assertions.assertEquals("2 Onion Bagel added to basket.", basket.addItem("BGLO", 2));
        Assertions.assertEquals("1 Plain Bagel added to basket.", basket.addItem("BGLP", 1));

        Assertions.assertEquals(2, basket.getBasketItems().get(basket.menu.getMenuItem("BGLO")));
        Assertions.assertEquals(1, basket.getBasketItems().get(basket.menu.getMenuItem("BGLP")));
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
    }

    @Test
    public void getItemCost(){
        Menu menu = new Menu();
        Assertions.assertEquals("0.49", menu.getItemCost("BGLS"));
    }

}
