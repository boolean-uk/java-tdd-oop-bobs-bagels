package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BasketTest {

    @Test
    public void TestShouldAddProductToBasket(){
        Basket basket = new Basket();

        Assertions.assertEquals("New product added to basket", basket.add("BGLO"));

        Assertions.assertEquals(1, basket.retrieveProductCount());
        Assertions.assertEquals("Product added to basket", basket.add("BGLO"));
    }

    @Test
    public void TestShouldAddBagelWithFilling(){
        Basket basket = new Basket();

        Assertions.assertEquals("New product added to basket", basket.add("BGLE", "FILX"));

    }



    @Test
    public void TestShouldIncreaseCurrentBasketValues(){
        Basket basket = new Basket();

        basket.add("BGLE");
        basket.add("BGLE");
        basket.add("BGLE");

        Assertions.assertEquals(3, basket.getQuantity("BGLE"));
    }

    @Test
    public void TestShouldNotExceedBasketCapacity(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();

        basket.add("BGLE");

        int currentCapacity = basket.retrieveBasketCapacity();

        for(int i = 0; i < currentCapacity; i++){
            basket.add("BGLE");
        }

        Assertions.assertEquals(11, basket.retrieveProductCount());

        //Try adding one more exceeding the limit
        basket.add("BGLE");

        //Should fail due to the +1
        Assertions.assertNotEquals(currentCapacity + 1, basket.retrieveProductCount());
    }

    @Test
    public void TestShouldIncrementProductIfBagelAndToppingIsSame(){
        Basket basket = new Basket();

        //Adding a bagel with bacon filling
        basket.add("BGLE", "FILB");
        Assertions.assertEquals("New product added to basket", basket.add("BGLE"));
        Assertions.assertEquals("New product added to basket", basket.add("BGLO", "FILX"));

        //If I now add the same bagel but different filling don't want the message indicating an increment of an existing product
        //This should fail because "Product added to basket" indicates that the object exists in the basket already incrementing the count.
        //Assertions.assertEquals("Product added to basket", basket.add("BGLE", "FILX"));

    }

    @Test
    public void TestShouldRemoveFromBasket(){
        Basket basket = new Basket();

        basket.add("BGLO");
        basket.add("BGLO");

        //there are two same bagels meaning that the below message should be true.
        Assertions.assertEquals("One product is removed", basket.remove("BGLO"));

        //Should have removed one bagel and decreased the productCount with one.
        Assertions.assertEquals(1, basket.retrieveProductCount());

        //Should make the onion bagels only one and give the other message.
        Assertions.assertEquals("This product is removed", basket.remove("BGLO"));
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

        Assertions.assertEquals(0.49f, basket.costOfProduct("BGLS"), 0.001);
  }

    @Test
    public void TestShouldGetTheTotalCostOfBasket(){
        Basket basket = new Basket();


        basket.add("BGLP");
        basket.add("BGLP");
        basket.add("BGLS");
        basket.add("COFC");

        //Sum should be 1.27 if it is set up correctly. For red test i have set up 1.3 which should fail due to not being exact.
        Assertions.assertEquals(2.56f, basket.totalCost(), 0.001);
    }


}


