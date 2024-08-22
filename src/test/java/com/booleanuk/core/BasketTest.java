package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BasketTest {

    @Test
    public void TestShouldAddProductToBasket(){
        Basket basket = new Basket();

        Assertions.assertEquals("New product added to basket", basket.add("BGLO"));

        Assertions.assertEquals(1, basket.retrieveProductCount());
        Assertions.assertEquals("Existing product added to basket", basket.add("BGLO"));
        Assertions.assertEquals(2, basket.retrieveProductCount());

        //Assertions.assertEquals("New product added to basket", basket.add("BGLO", "FILX"));
    }

    @Test
    public void TestShouldAddBagelWithFilling(){
        Basket basket = new Basket();

        basket.add("BGLE");

        Assertions.assertEquals("New product added to basket", basket.add("BGLE", "FILX"));

        Assertions.assertEquals("Existing product added to basket", basket.add("BGLE", "FILX"));

    }
    @Test
    public void TestShouldGiveErrorMessageIfProductIsNull(){
        Basket basket = new Basket();


        //This should now work due to some input being invalid. EX FILP does not exist
        Assertions.assertEquals("Failed to add order", basket.add("DELO"));
        Assertions.assertEquals("Failed to add order", basket.add("BGLO", "FILP"));
        Assertions.assertEquals("Failed to add order", basket.add("ReTs", "RED"));

    }

    //changed
    @Test
    public void TestShouldIncreaseCurrentBasketValues(){
        Basket basket = new Basket();

        basket.add("BGLE");
        basket.add("BGLE");
        basket.add("BGLE");

        Assertions.assertEquals(3, basket.getQuantity("BGLE"));

        basket.add("BGLE", "FILX");
        basket.add("BGLE", "FILX");

        Assertions.assertEquals(2, basket.getQuantity("BGLE", "FILX"));

        basket.add("BGLE", "FILX");
        Assertions.assertEquals(3, basket.getQuantity("BGLE", "FILX"));

    }

    @Test
    public void TestShouldNotExceedBasketCapacity(){
        Basket basket = new Basket();

        int currentCapacity = basket.retrieveBasketCapacity();

        for(int i = 0; i < currentCapacity; i++){
            basket.add("BGLE");
        }

        ///Basket is now full
        Assertions.assertEquals(10, basket.retrieveProductCount());

        //Try adding one more exceeding the limit getting the filed to add message
        Assertions.assertEquals("Basket is full", basket.add("BGLS"));
    }

    @Test
    public void TestShouldIncrementProductIfBagelAndToppingIsSame(){
        Basket basket = new Basket();

        Assertions.assertEquals("New product added to basket", basket.add("BGLE"));

        Assertions.assertEquals("New product added to basket", basket.add("BGLE", "FILX"));
        Assertions.assertEquals("Existing product added to basket", basket.add("BGLE", "FILX"));

    }

    @Test
    public void TestShouldRemoveFromBasket() {
        Basket basket = new Basket();


        basket.add("BGLE");
        basket.add("BGLE");

        //basket.add("BGLO", "FILX");

        Assertions.assertEquals(2, basket.retrieveProductCount());
        Assertions.assertEquals("One product is removed", basket.remove("BGLE"));
        Assertions.assertEquals("This product does not exist in basket!", basket.remove("BGLS"));
        Assertions.assertEquals("This product is removed", basket.remove("BGLE"));
    }

    @Test
    public void TestShouldRemoveBagelWithFillingFromBasket(){
        Basket basket = new Basket();


        basket.add("BGLE", "FILX");
        basket.add("BGLE", "FILS");
        basket.add("BGLE", "FILX");

        Assertions.assertEquals(3, basket.retrieveProductCount());
        Assertions.assertEquals("One product is removed", basket.remove("BGLE", "FILX"));
        Assertions.assertEquals("This product is removed", basket.remove("BGLE", "FILX"));


            }

    @Test
    public void TestShouldChangeBasketCapacity(){
        Basket basket = new Basket();

        for(int i = 0; i < basket.retrieveBasketCapacity(); i++){
            basket.add("BGLS");
        }

        Assertions.assertEquals(basket.retrieveBasketCapacity(), basket.retrieveProductCount());

        //Changing it
        basket.changeCapacity(15);

        //Should fail due to basketCapacity being changed
        Assertions.assertNotEquals(basket.retrieveBasketCapacity(), basket.retrieveProductCount());
    }

    @Test
    public void TestShouldGetCostOfProduct(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();

        Assertions.assertEquals(0.49f, basket.costOf(inventory.getItem("BGLO")), 0.0001);

        //Should fail because bagel has filling meaning the cost of product should be (0.49) + (0.12) = 0.61
        Assertions.assertEquals(0.61f, basket.costOf(inventory.getItem("BGLO", "FILX")), 0.0001);

  }

    @Test
    public void TestShouldGetTheTotalCostOfBasket(){
        Basket basket = new Basket();

        basket.add("BGLO", "FILS");
        basket.add("BGLP");
        basket.add("BGLP");
        basket.add("BGLP", "FILX");

        //Sum should be 1.9 if it is set up correctly. For red test I have set up 2.0 which should fail due to not being exact.
        Assertions.assertEquals(1.9f, basket.totalCost(), 0.0001);
    }

}


