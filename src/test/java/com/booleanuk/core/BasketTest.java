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
        Inventory inventory = new Inventory();

        Assertions.assertEquals("New product added to basket", basket.add(inventory.menu.get("OnionBagel")));
        Assertions.assertEquals("Existing product added to basket", basket.add(inventory.menu.get("OnionBagel")));
    }

    @Test
    public void ShouldNotAddOnlyFillingWithoutBagel(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();

        Assertions.assertEquals("You will need a bagel for that or it will be messy", basket.add(inventory.menu.get("BaconFilling")));

    }

    @Test
    public void ShouldAddFillingIfBagelExist(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();

        basket.add(inventory.menu.get("OnionBagel"));

        Assertions.assertEquals("New product added to basket", basket.add(inventory.menu.get("BaconFilling")));
    }

    @Test
    public void ShouldIncreaseCurrentBasketValues(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();

        basket.add(inventory.menu.get("OnionBagel"));
        basket.add(inventory.menu.get("OnionBagel"));
        basket.add(inventory.menu.get("OnionBagel"));


        Assertions.assertEquals(3, basket.currentBasket.get(inventory.menu.get("OnionBagel")));
        Assertions.assertEquals(3, basket.retrieveProductCount());
    }

    @Test
    public void ShouldNotExceedBasketCapacity(){
      Basket basket = new Basket();
      Inventory inventory = new Inventory();

      basket.add(inventory.menu.get("OnionBagel"));

      int currentCapacity = basket.retrieveBasketCapacity();

      for(int i = 0; i < currentCapacity; i++){
          basket.add(inventory.menu.get("OnionBagel"));
      }

      Assertions.assertEquals(10, basket.retrieveProductCount());

      //Try adding one more exceeding the limit
      basket.add(inventory.menu.get("OnionBagel"));

      //Should fail due to the +1
      Assertions.assertNotEquals(currentCapacity + 1, basket.retrieveProductCount());

  }

    @Test
    public void ShouldRemoveFromBasket(){
      Basket basket = new Basket();
      Inventory inventory = new Inventory();

      basket.add(inventory.menu.get("OnionBagel"));
      basket.add(inventory.menu.get("OnionBagel"));

      //there are two same bagels meaning that the below message should be true.
      Assertions.assertEquals("One product is removed", basket.remove(inventory.menu.get("OnionBagel")));

      //Should have removed one bagel and decreased the productCount with one.
      Assertions.assertEquals(1, basket.retrieveProductCount());

      //Should make the onion bagels only one and give the other message
      Assertions.assertEquals("This product is removed", basket.remove(inventory.menu.get("OnionBagel")));

  }

    @Test
    public void ShouldNotLetToppingExistWithoutBagel(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();

        basket.add(inventory.menu.get("OnionBagel"));
        basket.add(inventory.menu.get("EverythingBagel"));
        basket.add(inventory.menu.get("BaconFilling"));

        //Should be three items in the basket
        Assertions.assertEquals(3, basket.retrieveProductCount());

        //Should be able to remove this because we have 2 bagels one filling
        Assertions.assertEquals("This product is removed", basket.remove(inventory.menu.get("OnionBagel")));

        //Should not be able to remove this due to it only being on bagel left == assert not equals will result in fail
        Assertions.assertNotEquals("You cant have filling without bagel", basket.remove(inventory.menu.get("OnionBagel")));

    }

    @Test
    public void ShouldChangeBasketCapacity(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();

        for(int i = 0; i < basket.retrieveBasketCapacity(); i++){
            basket.add(inventory.menu.get("BlackCoffee"));
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
      Inventory inventory = new Inventory();

      Assertions.assertEquals(1.19f, basket.costOfProduct(inventory.menu.get("WhiteCoffee")), 0.001);
  }

    @Test
    public void ShouldGetTheTotalCostOfBasket(){
      Basket basket = new Basket();
      Inventory inventory = new Inventory();

      basket.add(inventory.menu.get("WhiteCoffee"));
      basket.add(inventory.menu.get("WhiteCoffee"));

      basket.add(inventory.menu.get("SesameBagel"));
      basket.add(inventory.menu.get("BaconFilling"));

      //Sum should be 2.99 if it is set up correctly. For red test i have set up 3.0 which should fail due to not being exact.
      Assertions.assertEquals(2.99f, basket.totalCost(), 0.001);
  }

}


