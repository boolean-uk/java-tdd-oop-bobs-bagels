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
    public void onlyAllowMenuOrderingTest(){
        Basket basket = new Basket();

        // Asserting that adding items from the menu to the basket works.
        String bagelName = "Bagel";
        String bagelVariant = "Plain";

        String coffeeName = "Coffee";
        String coffeeVariant = "Black";

        Item bagel = Menu.getItemFromMenu(bagelName, bagelVariant);
        Item coffee = Menu.getItemFromMenu(coffeeName, coffeeVariant);

        basket.addItemToBasket(bagel);
        basket.addItemToBasket(coffee);

        // Note that if the item is not in the basket, the function returns -1
        Assertions.assertNotEquals(-1, (int) basket.itemInBasket(bagel));
        Assertions.assertNotEquals(-1, (int) basket.itemInBasket(coffee));

        Bagel wrongBagel = new Bagel("ABCD", 99, "Bagel", "Chocolate");
        Coffee wrongCoffee = new Coffee("EFGH", 129, "Coffee", "Vanilla");

        String wrongBagelResult = basket.addItemToBasket(wrongBagel);
        String wrongCoffeeResult = basket.addItemToBasket(wrongCoffee);

        Assertions.assertEquals(-1, basket.itemInBasket(wrongBagel));
        Assertions.assertEquals(-1, basket.itemInBasket(wrongCoffee));

        Assertions.assertEquals(wrongBagelResult, wrongCoffeeResult);
        Assertions.assertEquals("This item is not on the menu.", wrongBagelResult);
    }

    @Test
    public void discountTest(){
        // Assert that 12 plain bagels provide 0.69 in discount.
        Basket basketOne = new Basket();

        for (int i = 0; i < 12; i++) {
            Item item = Menu.getItemFromMenu("Bagel", "Plain");
            basketOne.addItemToBasket(item);
        }

        int discount = basketOne.getDiscount();
        Assertions.assertEquals(69, discount);

        // Assert that 12 everything bagels provide 1.89 in discount.
        Basket basketTwo = new Basket();

        for (int i = 0; i < 12; i++) {
            Item item = Menu.getItemFromMenu("Bagel", "Everything");
            basketTwo.addItemToBasket(item);
        }

        discount = basketTwo.getDiscount();
        Assertions.assertEquals(189, discount);

        // Assert that 6 plain bagels adds 0.15 to the customers bill as instructed by the task.
        Basket basketThree = new Basket();

        for (int i = 0; i < 6; i++) {
            Item item = Menu.getItemFromMenu("Bagel", "Plain");
            basketThree.addItemToBasket(item);
        }

        discount = basketThree.getDiscount();
        Assertions.assertEquals(-15, discount);

        // Assert that 6 everything bagels bagels provide 0.45 to discount
        Basket basketFour = new Basket();

        for (int i = 0; i < 6; i++) {
            Item item = Menu.getItemFromMenu("Bagel", "Everything");
            basketFour.addItemToBasket(item);
        }

        discount = basketFour.getDiscount();
        Assertions.assertEquals(45, discount);

        // Assert that 6 coffees and 5 plain bagels adds 0.65 to discount
        Basket basketFive = new Basket();

        for (int i = 0; i < 5; i++) {
            Item item = Menu.getItemFromMenu("Bagel", "Plain");
            basketFive.addItemToBasket(item);
        }

        for (int i = 0; i < 6; i++) {
            Item item = Menu.getItemFromMenu("Coffee", "Black");
            basketFive.addItemToBasket(item);
        }

        discount = basketFive.getDiscount();
        Assertions.assertEquals(65, discount);

        // Assert that 6 coffees and 5 everything bagels adds 1.15 to discount
        Basket basketSix = new Basket();

        for (int i = 0; i < 5; i++) {
            Item item = Menu.getItemFromMenu("Bagel", "Everything");
            basketSix.addItemToBasket(item);
        }

        for (int i = 0; i < 6; i++) {
            Item item = Menu.getItemFromMenu("Coffee", "Black");
            basketSix.addItemToBasket(item);
        }

        discount = basketSix.getDiscount();
        Assertions.assertEquals(115, discount);

        // Assert that 8 everything bagels and 2 coffees returns discount for both coffee deal and bagel deal
        Basket basketSeven = new Basket();

        for (int i = 0; i < 8; i++) {
            Item item = Menu.getItemFromMenu("Bagel", "Everything");
            basketSeven.addItemToBasket(item);
        }

        for (int i = 0; i < 2; i++) {
            Item item = Menu.getItemFromMenu("Coffee", "Black");
            basketSeven.addItemToBasket(item);
        }

        int expectedDiscount = 45 + 23 * 2;

        discount = basketSeven.getDiscount();
        Assertions.assertEquals(expectedDiscount, discount);
    }




}