package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

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

        String name = "Plain Bagel";
        String result = basket.addItemToBasket(Menu.getItemFromMenu(name));

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
        String name = "Plain Bagel";
        basket.addItemToBasket(Menu.getItemFromMenu(name));

        Assertions.assertEquals(1, basket.numberOfItemsInBasket());

        // Change input to predefined input.
        InputStream backup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);

        String expectedResult = "Plain Bagel removed from basket.";
        String removeResult = basket.removeItemFromBasket();

        Assertions.assertEquals(expectedResult, removeResult);

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

        String name = "Plain Bagel";
        basket.addItemToBasket(Menu.getItemFromMenu(name));

        String name_2 = "Black Coffee";
        String result = basket.addItemToBasket(Menu.getItemFromMenu(name_2));

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

        Assertions.assertEquals(10, basket.getMaxBasketSize());

        basket.changeBasketSize(20);

        Assertions.assertEquals(20, basket.getMaxBasketSize());
    }

    @Test
    public void removeBagelNotInBasketTest() {
        /*
        As a member of the public,
        So I can change my order,
        I'd like to remove a bagel from my basket.
        */

        Basket basket = new Basket();
        String name = "Plain Bagel";
        basket.addItemToBasket(Menu.getItemFromMenu(name));

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
        String name = "Plain Bagel";
        Item item = Menu.getItemFromMenu(name);
        basket.addItemToBasket(item);
        assert item != null;
        total += item.getPrice();

        String name2 = "Black Coffee";

        Item item2 = Menu.getItemFromMenu(name2);
        basket.addItemToBasket(item2);
        assert item2 != null;
        total += item2.getPrice();

        Assertions.assertEquals((float) total /100, basket.calculateBasketCost());
    }

    @Test
    public void onlyAllowMenuOrderingTest(){
        Basket basket = new Basket();

        // Asserting that adding items from the menu to the basket works.
        String bagelName = "Plain Bagel";
        String coffeeName = "Black Coffee";

        Item bagel = Menu.getItemFromMenu(bagelName);
        Item coffee = Menu.getItemFromMenu(coffeeName);

        basket.addItemToBasket(bagel);
        basket.addItemToBasket(coffee);

        // Note that if the item is not in the basket, the function returns -1
        Assertions.assertTrue(basket.itemInBasket(bagel));
        Assertions.assertTrue(basket.itemInBasket(coffee));

        Bagel wrongBagel = new Bagel("ABCD", "Chocolate", 99);
        Coffee wrongCoffee = new Coffee("EFGH", "Vanilla", 129);

        String wrongBagelResult = basket.addItemToBasket(wrongBagel);
        String wrongCoffeeResult = basket.addItemToBasket(wrongCoffee);

        Assertions.assertFalse(basket.itemInBasket(wrongBagel));
        Assertions.assertFalse(basket.itemInBasket(wrongCoffee));

        Assertions.assertEquals(wrongBagelResult, wrongCoffeeResult);
        Assertions.assertEquals("This item is not on the menu.", wrongBagelResult);
    }

    @Test
    public void discountTest(){
        // Assert that 12 plain bagels provide 0.69 in discount.
        Basket basketOne = new Basket();

        for (int i = 0; i < 12; i++) {
            Item item = Menu.getItemFromMenu("Plain Bagel");
            basketOne.addItemToBasket(item);
        }

        basketOne.calculateDiscount();
        int discount = basketOne.getDiscount();
        Assertions.assertEquals(69, discount);

        // Assert that 12 everything bagels provide 1.89 in discount.
        Basket basketTwo = new Basket();

        for (int i = 0; i < 12; i++) {
            Item item = Menu.getItemFromMenu("Everything Bagel");
            basketTwo.addItemToBasket(item);
        }

        basketTwo.calculateDiscount();
        discount = basketTwo.getDiscount();
        Assertions.assertEquals(189, discount);

        // Assert that 6 plain bagels adds 0.15 to the customers bill as instructed by the task.
        Basket basketThree = new Basket();

        for (int i = 0; i < 6; i++) {
            Item item = Menu.getItemFromMenu("Plain Bagel");
            basketThree.addItemToBasket(item);
        }

        basketThree.calculateDiscount();
        discount = basketThree.getDiscount();
        Assertions.assertEquals(-15, discount);

        // Assert that 6 everything bagels provide 0.45 to discount
        Basket basketFour = new Basket();

        for (int i = 0; i < 6; i++) {
            Item item = Menu.getItemFromMenu("Everything Bagel");
            basketFour.addItemToBasket(item);
        }

        basketFour.calculateDiscount();
        discount = basketFour.getDiscount();
        Assertions.assertEquals(45, discount);

        // Assert that 6 coffees and 5 plain bagels adds 0.65 to discount
        Basket basketFive = new Basket();

        for (int i = 0; i < 5; i++) {
            Item item = Menu.getItemFromMenu("Plain Bagel");
            basketFive.addItemToBasket(item);
        }

        for (int i = 0; i < 6; i++) {
            Item item = Menu.getItemFromMenu("Black Coffee");
            basketFive.addItemToBasket(item);
        }

        basketFive.calculateDiscount();
        discount = basketFive.getDiscount();
        Assertions.assertEquals(65, discount);

        // Assert that 6 coffees and 5 everything bagels adds 1.15 to discount
        Basket basketSix = new Basket();

        for (int i = 0; i < 5; i++) {
            Item item = Menu.getItemFromMenu("Everything Bagel");
            basketSix.addItemToBasket(item);
        }

        for (int i = 0; i < 6; i++) {
            Item item = Menu.getItemFromMenu("Black Coffee");
            basketSix.addItemToBasket(item);
        }

        basketSix.calculateDiscount();
        discount = basketSix.getDiscount();
        Assertions.assertEquals(115, discount);

        // Assert that 8 everything bagels and 2 coffees returns discount for both coffee deal and bagel deal
        Basket basketSeven = new Basket();

        for (int i = 0; i < 8; i++) {
            Item item = Menu.getItemFromMenu("Everything Bagel");
            basketSeven.addItemToBasket(item);
        }

        for (int i = 0; i < 2; i++) {
            Item item = Menu.getItemFromMenu("Black Coffee");
            basketSeven.addItemToBasket(item);
        }

        int expectedDiscount = 45 + 23 * 2;

        basketSeven.calculateDiscount();
        discount = basketSeven.getDiscount();
        Assertions.assertEquals(expectedDiscount, discount);
    }


}