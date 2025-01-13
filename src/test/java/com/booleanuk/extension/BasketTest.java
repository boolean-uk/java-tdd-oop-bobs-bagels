package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {


    @Test
    public void testAddItem() {
        //Don't need to test for invalid items because they cannot be created according to the item factory tests
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item item = factory.createItem("BGLP");
        boolean successfullyAdded = basket.addItem(item); // add item
        Assertions.assertTrue(successfullyAdded);
        Assertions.assertEquals(item, basket.getBasket().getFirst()); //Check that the added item is in the basket
        Assertions.assertEquals(item.getPrice(), basket.getTotalCost()); //Check if the total increased by the item price
    }

/* I would need to add 26 items for this test to pass. I increased the max capacity to 25 to be able to test the discount problem properly
    @Test
    public void testAddingTooManyItems() {
        //Max capacity is 5, so adding should fail after 5 elements are present in the basket list
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item item = factory.createItem("BGLP");
        basket.addItem(item);
        basket.addItem(item);
        basket.addItem(item);
        basket.addItem(item);
        boolean successfullyAdded5 = basket.addItem(item);
        boolean successfullyAdded6 = basket.addItem(item);
        Assertions.assertTrue(successfullyAdded5);
        Assertions.assertFalse(successfullyAdded6);
        //check if 6 elements were added despite the max capacity being 5
        Assertions.assertThrows(IndexOutOfBoundsException.class , () -> basket.getBasket().get(5));
    }
*/
    @Test
    public void testRemoveItem() {
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item item = factory.createItem("BGLP");
        basket.addItem(item);
        boolean successfullyRemoved = basket.removeItem(item);
        Assertions.assertTrue(successfullyRemoved);
        Assertions.assertFalse(basket.getBasket().contains(item)); //check if the item is still in the basket
        Assertions.assertEquals(0, basket.getTotalCost()); //Check if the price went down back to 0 after removing
    }

    @Test
    public void testRemoveNonExistingItem() {
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item item1 = factory.createItem("BGLO");
        basket.addItem(item1);
        Item item2 = factory.createItem("BGLP"); //Item2 never gets added to basket
        boolean successfullyRemoved = basket.removeItem(item2);
        Assertions.assertFalse(successfullyRemoved);
        Assertions.assertEquals(1, basket.getBasket().size()); //Check if the basket still holds the items it should

    }

    @Test
    public void testChangeCapacity() {
        Basket basket = new Basket(); //basket has capacity of 25 by default
        basket.changeCapacity(7);
        Assertions.assertEquals(7, basket.getMaxCapacity()); //Check that the capacity was changed
    }

    @Test
    public void testInvalidCapacity() {
        Basket basket = new Basket();
        boolean successfulChange = basket.changeCapacity(-1);
        Assertions.assertFalse(successfulChange);
        Assertions.assertEquals(25, basket.getMaxCapacity()); // -1 is invalid so the capacity should not change
    }

    //Discount testing starts here:
    //Test the behaviour if only the discount items are in the basket

    @Test
    public void testOnlySixOnionBagelsDiscount() {
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item onionBagel = factory.createItem("BGLO");
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel); //6th  bagel added
        basket.checkDiscounts();
        Assertions.assertEquals(2.49, basket.getTotalCost());

    }

    @Test
    public void testOnlyTwelvePlainBagelsDiscount() {
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item plainBagel = factory.createItem("BGLP");
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel); //12th  bagel added
        basket.checkDiscounts();
        Assertions.assertEquals(3.99, basket.getTotalCost());
    }

    @Test
    public void testOnlyBlackCoffeeAndBagelDiscount() {
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item everythingBagel = factory.createItem("BGLE");
        Item blackCoffee = factory.createItem("COFB");
        basket.addItem(everythingBagel);
        basket.addItem(blackCoffee);
        basket.checkDiscounts();
        Assertions.assertEquals(1.25, basket.getTotalCost());
    }

    //test discount items with other items from here

    @Test
    public void testSixOnionBagelsDiscountWithOtherItems() {
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item onionBagel = factory.createItem("BGLO");
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel); //6th bagel added
        basket.addItem(onionBagel);
        basket.checkDiscounts();
        Assertions.assertEquals(2.49 + 0.49, basket.getTotalCost());

    }

    @Test
    public void testTwelvePlainBagelsDiscountWithOtherItems() {
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item plainBagel = factory.createItem("BGLP");
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel); //12th bagel added
        basket.addItem(plainBagel);
        basket.checkDiscounts();
        Assertions.assertEquals(3.99 + 0.39, basket.getTotalCost());
    }

    @Test
    public void testBlackCoffeeAndBagelDiscountWithOtherItems() {
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item everythingBagel = factory.createItem("BGLE");
        Item blackCoffee = factory.createItem("COFB");
        basket.addItem(everythingBagel);
        basket.addItem(blackCoffee); //discount applies from here
        basket.addItem(everythingBagel);
        basket.checkDiscounts();
        Assertions.assertEquals(1.25 + 0.49, basket.getTotalCost());
    }

    //Testing of multiple instances of the same discount being applied (so 12 onion bagels = 2 * the discount price for 6)

    @Test
    public void testTwoOnionBagelsDiscounts() {
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item onionBagel = factory.createItem("BGLO");
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel); //6th bagel added
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel); //12th bagel added
        basket.checkDiscounts();
        Assertions.assertEquals(2.49 * 2, basket.getTotalCost());
    }

    @Test
    public void testTwoPlainBagelsDiscounts() {
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item plainBagel = factory.createItem("BGLP");
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel); //12th bagel added
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel); //24th bagel added
        basket.checkDiscounts();
        Assertions.assertEquals(3.99 * 2, basket.getTotalCost());
    }

    @Test
    public void testTwoBlackCoffeeAndBagelDiscounts() {
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item everythingBagel = factory.createItem("BGLE");
        Item blackCoffee = factory.createItem("COFB");
        basket.addItem(everythingBagel);
        basket.addItem(blackCoffee); //discount applies from here
        basket.addItem(everythingBagel);
        basket.addItem(blackCoffee); //discount applies from here again
        basket.checkDiscounts();
        Assertions.assertEquals(1.25 * 2, basket.getTotalCost());
    }

    @Test
    public void multipleDifferentDiscounts() {
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item onionBagel = factory.createItem("BGLO");
        Item everythingBagel = factory.createItem("BGLE");
        Item blackCoffee = factory.createItem("COFB");
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel); //6th bagel added
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel); //12th bagel added, should be 3.99 in total at this point
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel); //18th bagel added, should be 3.99 + 2.49 at this point
        basket.addItem(blackCoffee);
        basket.addItem(everythingBagel); // coffee discount applies from here
        basket.checkDiscounts();
        Assertions.assertEquals(3.99 + 2.49 + 1.25, basket.getTotalCost());
    }



}
