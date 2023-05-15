package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BasketTest {
    Inventory inventory;

    public BasketTest() {
        ArrayList<Item> itemArrayList = new ArrayList<>();
        itemArrayList.add(new Item("Bagel", 0.49, "BGLO", "Onion"));
        itemArrayList.add(new Item("Bagel", 0.39, "BGLP", "Plain"));
        itemArrayList.add(new Item("Bagel", 0.49, "BGLE", "Everything"));
        itemArrayList.add(new Item("Bagel", 0.49, "BGLS", "Sesame"));
        itemArrayList.add(new Item("Coffee", 0.99, "COFB", "Black"));
        itemArrayList.add(new Item("Coffee", 1.19, "COFW", "White"));
        itemArrayList.add(new Item("Coffee", 1.29, "COFC", "Cappuccino"));
        itemArrayList.add(new Item("Coffee", 1.29, "COFL", "Latte"));
        itemArrayList.add(new Item("Filling", 0.12, "FILB", "Bacon"));
        itemArrayList.add(new Item("Filling", 0.12, "FILE", "Egg"));
        itemArrayList.add(new Item("Filling", 0.12, "FILC", "Cheese"));
        itemArrayList.add(new Item("Filling", 0.12, "FILX", "Cream Cheese"));
        itemArrayList.add(new Item("Filling", 0.12, "FILS", "Smoked Salmon"));
        itemArrayList.add(new Item("Filling", 0.12, "FILH", "Ham"));

        this.inventory = new Inventory(itemArrayList);
    }

    @Test
    public void testAddItem() {
         //Test for successfully added Bagel
        Basket basket = new Basket(this.inventory);
        boolean testItem = false;
        String testSku = "BGLO";
        basket.addItem(testSku);

        for (int i = 0; i < basket.getItems().size() ; i++) {
            if (basket.getItems().get(i).getSku().equals(testSku)) {
                testItem = true;
                break;
            }
        }
        Assertions.assertTrue(testItem);

        // test for item does not exist
        String testSku2 = "ABCD";
        basket.addItem(testSku2);
        testItem = false;
        for (int i = 0; i < basket.getItems().size() ; i++) {
            if (basket.getItems().get(i).getSku().equals(testSku2)) {
                testItem = true;
                break;
            }
        }
        Assertions.assertFalse(testItem);

        // Test for failure and item can not be added because basket capacity
        basket.addItem("BGLP");
        basket.addItem("COFB");
        String testSku3 = "COFW";
        basket.addItem(testSku3);
        testItem = false;
        for (int i = 0; i < basket.getItems().size() ; i++) {
            if (basket.getItems().get(i).getSku().equals(testSku3)) {
                testItem = true;
                break;
            }
        }
        // item can not be added because basket capacity is full
        Assertions.assertFalse(testItem);
    }

    @Test
    public void testRemoveItem() {
        // Test for successfully removed Bagel
        Basket basket = new Basket(this.inventory);
        boolean testItem = true;
        basket.addItem("BGLP");
        basket.addItem("COFB");
        String testSku = "COFB";
        Assertions.assertTrue(basket.removeItem(testSku));

        // Test for failure
        testSku = "COFW";
        Assertions.assertFalse(basket.removeItem(testSku));
    }

    @Test
    public void testUpdateBasketCapacity() {
        //Test for successfully updated capacity
        Basket basket = new Basket(this.inventory);
        Assertions.assertTrue(basket.updateBasketCapacity(5));
        Assertions.assertEquals(5, basket.getBasketCapacity());

        //Test for failed updated capacity (0 or negative number)
        Assertions.assertFalse(basket.updateBasketCapacity(0));
        Assertions.assertFalse(basket.updateBasketCapacity(-1));

        //Test for failed updated capacity (capacity made smaller than basket size)
        basket.addItem("COFB");
        basket.addItem("BGLO");
        basket.addItem("FILS");

        Assertions.assertFalse(basket.updateBasketCapacity(2));
    }

    @Test
    public void testTotalCost() {
        Basket basket = new Basket(this.inventory);
        basket.addItem("COFB");
        basket.addItem("BGLE");
        basket.addItem("FILX");
        basket.removeItem("COFB");

        Assertions.assertEquals(0.61, basket.totalCost());
    }

    @Test
    public void testOnionBagelsDiscount()
    {
        Basket basket = new Basket(this.inventory);

        for (int i = 1; i <= 6; i++) {
            basket.addItem("BGLO");
        }

        Assertions.assertEquals(2.49, basket.totalCost());
    }

    @Test
    public void testPlainBagelsDiscount()
    {
        Basket basket = new Basket(this.inventory);

        for (int i = 1; i <= 12; i++) {
            basket.addItem("BGLP");
        }

        Assertions.assertEquals(3.99, basket.totalCost());
    }

    @Test
    public void testEverythingBagelsDiscount()
    {
        Basket basket = new Basket(this.inventory);

        for (int i = 1; i <= 6; i++) {
            basket.addItem("BGLE");
        }

        Assertions.assertEquals(2.49, basket.totalCost());
    }

    @Test
    public void testCoffeeBagelDiscount()
    {
        Basket basket = new Basket(this.inventory);

            basket.addItem("BGLP");
            basket.addItem("COFC");

        Assertions.assertEquals(1.25, basket.totalCost());
    }

    @Test
    public void testCombinationDiscounts() {
        Basket basket = new Basket(this.inventory);

        for (int i = 1; i <= 12; i++) {
            basket.addItem("BGLP");
        }

        basket.addItem("BGLP");
        basket.addItem("COFC");

        Assertions.assertEquals(5.24, );

    }

    @Test
    public void testItemPrice() {
        // test success
        Basket basket = new Basket(this.inventory);
        Assertions.assertEquals(0.39, basket.itemPrice("BGLP"));

        //test failure
        Assertions.assertEquals(0.00, basket.itemPrice("ABCD"));
    }



}
