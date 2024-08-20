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
    public void ShouldChangeBasketCapacity(){
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
    public void shouldGetCostOfProduct(){
        Basket basket = new Basket();

        Assertions.assertEquals(0.49f, basket.costOfProduct("BGLS"), 0.001);

  }

    @Test
    public void ShouldGetTheTotalCostOfBasket(){

  }

}


