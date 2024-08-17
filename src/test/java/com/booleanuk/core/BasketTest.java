package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class BasketTest {

    Bagel onionBagel = new Bagel("BGLO",	0.49, "Bagel",	"Onion");
    Coffee blackCoffee = new Coffee("COFB",	0.99,	"Coffee",	"Black");


    @Test
    public void ShouldShowProduct(){

        Assertions.assertEquals("BGLO 0.49 Bagel Onion", onionBagel.showProduct());
        Assertions.assertEquals("COFB 0.99 Coffee Black", blackCoffee.showProduct());

        onionBagel.showProduct();
    }

    @Test
    public void ShouldAddProductToBasket(){
        Basket basket = new Basket();

        basket.add(onionBagel);
        basket.add(blackCoffee);

        ArrayList<String> expectedNames = new ArrayList<>();
        expectedNames.add("Bagel");
        expectedNames.add("Coffee");


        ArrayList<String> actualNames = new ArrayList<>();
        for (Product product : basket.currentBasket.keySet()){
            String name = product.getName();
            actualNames.add(name);
        }

        Assertions.assertEquals(expectedNames, actualNames);
    }

    @Test
    public void ShouldIncreaseCurrentBasketValues(){
        Basket basket = new Basket();

        basket.add(onionBagel);
        basket.add(onionBagel);
        basket.add(blackCoffee);


        ArrayList<Integer> expectedNames = new ArrayList<>();
        expectedNames.add(1);
        expectedNames.add(2);

        ArrayList<Integer> actualNames = new ArrayList<>();
        for (Product product : basket.currentBasket.keySet()){
            int i = basket.currentBasket.get(product);
            actualNames.add(i);
        }

        Assertions.assertEquals(expectedNames, actualNames);
        Assertions.assertEquals(3, basket.getProductCount());
    }

  @Test
  public void ShouldNotExceedBasketCapacity(){
      Basket basket = new Basket();

      int currentCapacity = basket.getBasketCapacity();

      for(int i = 0; i < currentCapacity; i++){
          basket.add(onionBagel);
      }

      Assertions.assertEquals(10, basket.getProductCount());

      //Try adding one more exceeding the limit
      basket.add(onionBagel);

      //Should fail due to the +1
      Assertions.assertNotEquals(currentCapacity + 1, basket.getProductCount());

  }

  @Test
    public void ShouldRemoveFromBasket(){
      Basket basket = new Basket();

      basket.add(onionBagel);
      basket.add(onionBagel);

      //Should fail: there are two same bagels meaning that the below message should be true.
      Assertions.assertNotEquals("One product is removed", basket.remove(onionBagel));

      //Should have removed one bagel and decreased the productCount with one.
      Assertions.assertEquals(1, basket.getProductCount());

      //Should make the onion bagels only one and give the other message
      Assertions.assertEquals("This product is removed", basket.remove(onionBagel));






  }



}


