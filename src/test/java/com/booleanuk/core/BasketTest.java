package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    public void AddBagelTest(){
        /*
        As a member of the public,
        So I can order a bagel before work,
        I'd like to add a specific type of bagel to my basket.
         */
        Basket basket = new Basket();

        // Assert that the basket is empty
        Assertions.assertEquals(0, basket.numberOfItemsInBasket());

        String name = "Bagel";
        String variant = "Plain";
        String result = basket.addItemToBasket(Menu.getItemFromMenu(name, variant));

        String expected = "Plain Bagel added to basket.";

        // Assert that the number of items in the basket has increased to 1
        Assertions.assertEquals(1, basket.numberOfItemsInBasket());

        // Assert that the basket execution of addItemToBasket function returns the correct string
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void removeBagelTest(){
        /*
        As a member of the public,
        So I can change my order,
        I'd like to remove a bagel from my basket.
        */

        /*
        Basket basket = new Basket();
        String name = "Bagel";
        String variant = "Plain";
        basket.addItemToBasket(Menu.getItemFromMenu(name, variant));

        Assertions.assertEquals(1, basket.numberOfItemsInBasket());

        String removeResult = basket.removeItemFromBasket();
        */





    }

}


/*
### 3
``
As a member of the public,
So that I can not overfill my small bagel basket
I'd like to know when my basket is full when I try adding an item beyond my basket capacity.
``
 */