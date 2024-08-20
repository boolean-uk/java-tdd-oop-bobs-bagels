package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;

public class BasketTest {
    @Test
    public void AddBagelTest() {
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
    public void removeBagelTest() {
        /*
        As a member of the public,
        So I can change my order,
        I'd like to remove a bagel from my basket.
        */

        Basket basket = new Basket();
        String name = "Bagel";
        String variant = "Plain";
        basket.addItemToBasket(Menu.getItemFromMenu(name, variant));

        Assertions.assertEquals(1, basket.numberOfItemsInBasket());

        // Change input to predefined input.
        InputStream backup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);

        String expectedResult = "Plain Bagel removed from basket.";
        String removeResult = basket.removeItemFromBasket();

        Assertions.assertEquals(expectedResult, removeResult);

        System.out.println("Items in basket: basket.numberOfItemsInBasket()");
        Assertions.assertEquals(0, basket.numberOfItemsInBasket());

        System.setIn(backup);
    }

    @Test
    public void AddItemWhenBasketIsFullTest() {
           /*
            As a member of the public,
            So that I can not overfill my small bagel basket
            I'd like to know when my basket is full when I try adding an item beyond my basket capacity.
            */
        Basket basket = new Basket();

        basket.changeBasketSize(1);

        String name = "Bagel";
        String variant = "Plain";
        basket.addItemToBasket(Menu.getItemFromMenu(name, variant));

        String name_2 = "Coffee";
        String variant_2 = "Black";
        String result = basket.addItemToBasket(Menu.getItemFromMenu(name_2, variant_2));

        String expected = "Basket is full.";

        // Assert that the basket execution of addItemToBasket function returns the correct string
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void changeSizeOfBasketTest(){
        /*
        As a Bob's Bagels manager,
        So that I can expand my business,
        I’d like to change the capacity of baskets.
        */

        Basket basket = new Basket();

        basket.changeBasketSize(10);

        Assertions.assertEquals(10, basket.getBasketSize());

        basket.changeBasketSize(20);

        Assertions.assertEquals(20, basket.getBasketSize());
    }

    @Test
    public void removeBagelNotInBasketTest() {
        /*
        As a member of the public,
        So I can change my order,
        I'd like to remove a bagel from my basket.
        */

        Basket basket = new Basket();
        String name = "Bagel";
        String variant = "Plain";
        basket.addItemToBasket(Menu.getItemFromMenu(name, variant));

        // Change input to predefined input.
        InputStream backup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);

        String expectedResult = "Invalid option.";
        String removeResult = basket.removeItemFromBasket();

        Assertions.assertEquals(expectedResult, removeResult);

        System.setIn(backup);
    }

    @Test
    public void getTotalCostOfItemsInBasket() {
        /*
        As a customer,
        So I know how much money I need,
        I'd like to know the total cost of items in my basket.
         */
        int total = 0;

        Basket basket = new Basket();
        String name = "Bagel";
        String variant = "Plain";
        Item item = Menu.getItemFromMenu(name, variant);
        basket.addItemToBasket(item);
        assert item != null;
        total += item.getPrice();

        String name2 = "Coffee";
        String variant2 = "Black";

        Item item2 = Menu.getItemFromMenu(name2, variant2);
        basket.addItemToBasket(item2);
        assert item2 != null;
        total += item2.getPrice();

        Assertions.assertEquals((float) total /100, basket.calculateBasketCost());
    }

    @Test
    public void getCostOfBagel(){
        /*
        As a customer,
        So I know what the damage will be,
        I'd like to know the cost of a bagel before I add it to my basket.
         */

        String name = "Bagel";
        String variant = "Plain";
        Item item = Menu.getItemFromMenu(name, variant);

        /*
        Assert that price of bagel can be found before adding to basket.
        Expected price fetched from menu.
        */
        assert item != null;
        int itemPrice = item.price;
        int expectedPrice = 39;
        Assertions.assertEquals((float) expectedPrice/100, (float) itemPrice /100);
    }

    @Test
    public void addFillingToBagelTest(){
        String name = "Bagel";
        String variant = "Plain";
        Item item = Menu.getItemFromMenu(name, variant);
        assert item != null;
        Bagel bagel = new Bagel(item.sku, item.price, item.name, item.variant);

        Filling filling = Menu.getFillingFromMenu();
        bagel.addFilling(filling);

        assert(bagel.fillings.contains(filling));
    }


}