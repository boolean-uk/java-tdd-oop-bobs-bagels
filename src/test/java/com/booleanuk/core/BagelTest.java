package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {

    @Test
    public void addFillingToBagelTest(){
        String name = "Bagel";
        String variant = "Plain";
        Item item = Menu.getItemFromMenu(name, variant);
        assert item != null;
        Bagel bagel = new Bagel(item.sku, item.price, item.name, item.variant);

        String fillingName = "Filling";
        String fillingVariant = "Bacon";
        Filling filling = Menu.getFillingFromMenu(fillingName, fillingVariant);
        bagel.addFilling(filling);
        assert(bagel.getFillings().contains(filling));

        String expectedResult = "Bacon added to your bagel.";
        String result = bagel.addFilling(filling);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void getCostOfBagel(){
        /*
        As a customer,
        So I know what the damage will be,
        I'd like to know the cost of a bagel before I add it to my basket.
         */

        String name = "Bagel";
        String variant = "Plain";
        Item item = Menu.getItemFromMenu(name, variant);

        /*
        Assert that price of bagel can be found before adding to basket.
        Expected price fetched from menu.
        */
        assert item != null;
        int itemPrice = item.price;
        int expectedPrice = 39;
        Assertions.assertEquals((float) expectedPrice/100, (float) itemPrice /100);
    }


}

/*

### 8
``
As a customer,
So I can shake things up a bit,
I'd like to be able to choose fillings for my bagel.
``

### 9
``
As a customer,
So I don't over-spend,
I'd like to know the cost of each filling before I add it to my bagel order.
``

### 10
``
As the manager,
So we don't get any weird requests,
I want customers to only be able to order things that we stock in our inventory.
``

 */