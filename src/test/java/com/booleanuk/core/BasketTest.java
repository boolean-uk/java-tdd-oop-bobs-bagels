package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {


    @Test
    public void testBasket(){
        Basket basket = new Basket(10, new Inventory());
        Assertions.assertEquals(10, basket.capacity);
    }

    @Test
    public void testAddBagel() {
        Basket basket = new Basket(10, new Inventory());
        Item item1 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.SESAME);
        basket.addBagel(item1);
        Assertions.assertTrue(basket.getListOfBasket().contains(item1), "The bagel should be in the basket");

    }

    @Test
    public void testAddCoffee() {
        Basket basket = new Basket(10, new Inventory());
        Item item1 = new Coffee("COFC",1.29, "Coffee", "Capuccino");
        basket.addBagel(item1);
        Assertions.assertTrue(basket.getListOfBasket().contains(item1), "The bagel should be in the basket");

    }

    @Test
    public void testRemoveBagel() {
        Basket basket = new Basket(10, new Inventory());
        Item item1 = new Bagel("BGLO", 0.49, "Bagel", Bagel.BagelVariant.ONION);
        Item item2 = new Bagel("BGLO", 0.49, "Bagel", Bagel.BagelVariant.EVERYTHING);
        Item item3 = new Bagel("BGLO", 0.49, "Bagel", Bagel.BagelVariant.EVERYTHING);

        basket.addBagel(item1);
        basket.addBagel(item2);
        basket.addBagel(item3);

        basket.removeBagel(item1);

        Assertions.assertEquals(2, basket.getListOfBasket().size());
    }

    @Test
    public void testRemoveBagelIfNotExist() {
        Basket basket = new Basket(10, new Inventory());
        Item item1 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.ONION);
        Item item2 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.EVERYTHING);
        Item item3 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.EVERYTHING);
        basket.addBagel(item1);
        basket.addBagel(item2);
        String result1= basket.removeBagel(item3);
        Assertions.assertEquals(result1,"The bagel does not exist in the basket");

    }

    @Test
    public void isFull() {
        Basket basket = new Basket(2, new Inventory());
        Item item1 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.ONION);
        Item item2 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.EVERYTHING);
        Item item3 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.PLAIN);
        basket.addBagel(item1);
        basket.addBagel(item2);
        basket.addBagel(item3);
        Assertions.assertEquals(2,basket.getListOfBasket().size());


    }

    @Test
    public void testGetTotalCost() {
        Basket basket = new Basket(2, new Inventory());
        Item item1 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.ONION);
        Item item2 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.EVERYTHING);
        basket.addBagel(item1);
        basket.addBagel(item2);
        Assertions.assertEquals(0.98, basket.getTotalCost(), 0.001);

    }


    @Test
    public void testAddBagelThatDoesNotExist(){
        Basket basket = new Basket(2, new Inventory());
        Item item1 = new Bagel("lo",0.49, "Bagel", Bagel.BagelVariant.ONION);
        Item item2 = new Bagel("lo",0.49, "Bagel", Bagel.BagelVariant.EVERYTHING);
        basket.addBagel(item1);
        basket.addBagel(item2);

    }

    @Test
    public void testAddFillingToBagel () {

        Basket basket = new Basket(10, new Inventory());
        Bagel item1 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.SESAME);
        Filling filling = new Filling("FILE", 0.12, "Filling", "Egg");
        basket.addBagel(item1);
        item1.setFilling(filling);
        Assertions.assertEquals("Egg", item1.getFilling().getFillingType());


    }


    @Test
    public void testGetTotalCostWithFilling() {
        Basket basket = new Basket(2, new Inventory());
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.ONION);
        basket.addBagel(bagel1);

        Filling filling = new Filling("FILE", 0.12, "Filling", "Egg");
        bagel1.setFilling(filling);

        Assertions.assertEquals(0.61, basket.getTotalCost(), 0.001);

    }

    @Test
    public void testIfInInventory() {
        Inventory inventory = new Inventory(); // Ensure Inventory is properly initialized with items
        Bagel bagel1 = new Bagel("BGLO", 0.49, "Bagel", Bagel.BagelVariant.ONION);
        Filling filling = new Filling("FILE", 0.12, "Filling", "Egg");
        Coffee coffee = new Coffee("COFC", 1.29, "Coffee", "Capuccino");

        Assertions.assertTrue(inventory.isItemAvailable(bagel1.getSku()), "Bagel should be in the inventory");
        Assertions.assertTrue(inventory.isItemAvailable(filling.getSku()), "Filling should be in the inventory");
        Assertions.assertTrue(inventory.isItemAvailable(coffee.getSku()), "Coffee should be in the inventory");
    }

    @Test
    public void testIfInInventoryNotExist() {
        Inventory inventory = new Inventory(); // Ensure Inventory is properly initialized with items
        Bagel bagel1 = new Bagel("Bol", 0.49, "Bagel", Bagel.BagelVariant.ONION);
        Filling filling = new Filling("hj", 0.12, "Filling", "Egg");
        Coffee coffee = new Coffee("lo", 1.29, "Coffee", "Capuccino");

        Assertions.assertFalse(inventory.isItemAvailable(bagel1.getSku()), "Bagel should be in the inventory");
        Assertions.assertFalse(inventory.isItemAvailable(filling.getSku()), "Filling should be in the inventory");
        Assertions.assertFalse(inventory.isItemAvailable(coffee.getSku()), "Coffee should be in the inventory");
    }

    @Test
    public void testTotalCostWithAllThreeItems(){
        Basket basket = new Basket(2, new Inventory());
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.ONION);
        basket.addBagel(bagel1);

        Filling filling = new Filling("FILE", 0.12, "Filling", "Egg");
        bagel1.setFilling(filling);

        Coffee coffee = new Coffee("COFC", 1.29, "Coffee", "Capuccino");

        basket.addBagel(coffee);

        Assertions.assertEquals(1.90, basket.getTotalCost(), 0.001);
    }




}
