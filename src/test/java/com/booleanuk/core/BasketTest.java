package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BasketTest {


    @Test
    public void ShouldShowProduct(){
        Basket basket = new Basket();
        Bagel onionBagel = new Bagel("BGLO",	0.49, "Bagel",	"Onion");
        Coffee blackCoffee = new Coffee("COFB",	0.99,	"Coffee",	"Black");

        Assertions.assertEquals("BGLO 0.49 Bagel Onion", onionBagel.showProduct());
        Assertions.assertEquals("COFB 0.99 Coffee Black", blackCoffee.showProduct());
    }

    @Test
    public void ShouldAddProductToBasket(){
        Basket basket = new Basket();
        Bagel onionBagel = new Bagel("BGLO",	0.49, "Bagel",	"Onion");

        Assertions.assertEquals("New product added to basket", basket.add(onionBagel));
        Assertions.assertEquals("Existing product added to basket", basket.add(onionBagel));
    }

    @Test
    public void ShouldIncreaseCurrentBasketValues(){
        Basket basket = new Basket();

        Bagel onionBagel = new Bagel("BGLO",	0.49, "Bagel",	"Onion");

        basket.add(onionBagel);
        basket.add(onionBagel);
        basket.add(onionBagel);


        Assertions.assertEquals(3, basket.currentBasket.get(onionBagel));
        Assertions.assertEquals(3, basket.retrieveProductCount());
    }

  @Test
  public void ShouldNotExceedBasketCapacity(){
      Basket basket = new Basket();

      Bagel onionBagel = new Bagel("BGLO",	0.49, "Bagel",	"Onion");

      int currentCapacity = basket.retrieveBasketCapacity();

      for(int i = 0; i < currentCapacity; i++){
          basket.add(onionBagel);
      }

      Assertions.assertEquals(10, basket.retrieveProductCount());

      //Try adding one more exceeding the limit
      basket.add(onionBagel);

      //Should fail due to the +1
      Assertions.assertNotEquals(currentCapacity + 1, basket.retrieveProductCount());

  }

  @Test
    public void ShouldRemoveFromBasket(){
      Basket basket = new Basket();
      Bagel onionBagel = new Bagel("BGLO",	0.49, "Bagel",	"Onion");
      Coffee blackCoffee = new Coffee("COFB",	0.99,	"Coffee",	"Black");

      basket.add(onionBagel);
      basket.add(onionBagel);

      //there are two same bagels meaning that the below message should be true.
      Assertions.assertEquals("One product is removed", basket.remove(onionBagel));

      //Should have removed one bagel and decreased the productCount with one.
      Assertions.assertEquals(1, basket.retrieveProductCount());

      //Should make the onion bagels only one and give the other message
      Assertions.assertEquals("This product is removed", basket.remove(onionBagel));

  }

  @Test
    public void ShouldChangeBasketCapacity(){
        Basket basket = new Basket();
        Bagel onionBagel = new Bagel("BGLO",	0.49, "Bagel",	"Onion");
        Coffee blackCoffee = new Coffee("COFB",	0.99,	"Coffee",	"Black");

        for(int i = 0; i < basket.retrieveBasketCapacity(); i++){
            basket.add(blackCoffee);
        }

        Assertions.assertEquals(basket.retrieveBasketCapacity(), basket.retrieveProductCount());

        //Changing it
        basket.changeCapacity(15);

        //Should fail due to basketCapacity being changed
        Assertions.assertNotEquals(basket.retrieveBasketCapacity(), basket.retrieveProductCount());
  }

}


