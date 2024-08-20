package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class BasketTest {

    @Test
    public void ShouldAddProductToBasket(){
        Basket basket = new Basket();

        Assertions.assertEquals("New product added to basket", basket.add("BGLO"));

        Assertions.assertEquals(1, basket.retrieveProductCount());
        Assertions.assertNotEquals("Product added to basket", basket.add("BGLO"));
    }

    @Test
    public void ShouldIncreaseCurrentBasketValues(){
        Basket basket = new Basket();

        basket.add("BGLE");
        basket.add("BGLE");
        basket.add("BGLE");

        Assertions.assertEquals(3, basket.getQuantity("BGLE"));
    }

    @Test
    public void ShouldNotExceedBasketCapacity(){
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
    public void ShouldRemoveFromBasket(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();

        basket.add("BGLO");
        basket.add("BGLO");

        //there are two same bagels meaning that the below message should be true.
        Assertions.assertEquals("One product is removed", basket.remove("BGLO"));

        //Should have removed one bagel and decreased the productCount with one.
        Assertions.assertEquals(1, basket.retrieveProductCount());

        //Should fail due to different return types for the last item
        Assertions.assertEquals("One product is removed", basket.remove("BGLO"));
    }

    @Test
    public void ShouldNotLetToppingExistWithoutBagel(){

    }

    @Test
    public void ShouldChangeBasketCapacity(){

  }

    @Test
    public void shouldGetCostOfProduct(){

  }

    @Test
    public void ShouldGetTheTotalCostOfBasket(){

  }

}


