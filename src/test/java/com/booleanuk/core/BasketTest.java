package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class BasketTest {

   @Test
   public void createBasketTest() {
       Basket basket = new Basket();

       Assertions.assertEquals(0, basket.countTotalItems());
   }

   @Test
    public void addBagelAndCoffeeAndFillingToBasketTest() {
       Basket basket = new Basket();
       Bagel bagel = new Bagel("BGLO", 0.49, "Onion");
       Coffee coffee = new Coffee("COFB", 1.29, "Black");
       Filling filling = new Filling("FILH", 0.12, "Ham");
       basket.addItemToBasket(bagel.getSKU());
       basket.addItemToBasket(coffee.getSKU());
       basket.addItemToBasket(filling.getSKU());

       //Populate a reference list
       ArrayList<Item> itemList = new ArrayList<>();
       itemList.add(bagel);
       itemList.add(coffee);
       itemList.add(filling);

       System.out.println(basket.checkAllItems());

       for (int i = 0; i < basket.countTotalItems(); i++ ){
           Assertions.assertEquals(1, basket.checkAllItems().get(itemList.get(i).getSKU()));
       }
   }
}
