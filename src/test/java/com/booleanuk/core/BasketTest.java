package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class BasketTest {

    @Test
    public void ShouldShowProduct(){
        Bagel myBagel = new Bagel("BGLO",	0.49, "Bagel",	"Onion");
        Coffee blackCoffee = new Coffee("COFB",	0.99,	"Coffee",	"Black");

        Assertions.assertEquals("BGLO 0.49 Bagel Onion", myBagel.showProduct());
        Assertions.assertEquals("COFB 0.99 Coffee Black", blackCoffee.showProduct());

        myBagel.showProduct();
    }

    @Test
    public void ShouldAddProductToBasket(){
        Basket basket = new Basket();

        Bagel onionBagel = new Bagel("BGLO",	0.49, "Bagel",	"Onion");
        Coffee blackCoffee = new Coffee("COFB",	0.99,	"Coffee",	"Black");

        basket.addToCurrentBasket(onionBagel);
        basket.addToCurrentBasket(blackCoffee);

        ArrayList<String> expectedNames = new ArrayList<>();
        expectedNames.add("Coffee");
        expectedNames.add("Bagel");

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

        Bagel onionBagel = new Bagel("BGLO",	0.49, "Bagel",	"Onion");
        Coffee blackCoffee = new Coffee("COFB",	0.99,	"Coffee",	"Black");

        basket.addToCurrentBasket(onionBagel);
        basket.addToCurrentBasket(blackCoffee);
        basket.addToCurrentBasket(onionBagel);;

        ArrayList<Integer> expectedNames = new ArrayList<>();
        expectedNames.add(1);
        expectedNames.add(2);

        ArrayList<Integer> actualNames = new ArrayList<>();
        for (Product product : basket.currentBasket.keySet()){
            int i = basket.currentBasket.get(product);
            actualNames.add(i);
        }

        Assertions.assertNotEquals(expectedNames, actualNames);
    }

}


