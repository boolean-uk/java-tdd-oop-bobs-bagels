package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {

    @Test
    public void addFillingToBagelTest(){
        String name = "Plain Bagel";
        Item item = Menu.getItemFromMenu(name);
        assert item != null;
        Bagel bagel = new Bagel(item.getSKU(), item.getName(), item.getPrice());

        String fillingName = "Bacon";
        Filling filling = Menu.getFillingFromMenu(fillingName);
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

        String name = "Plain Bagel";
        Item item = Menu.getItemFromMenu(name);

        /*
        Assert that price of bagel can be found before adding to basket.
        Expected price fetched from menu.
        */
        assert item != null;
        int itemPrice = item.getPrice();
        int expectedPrice = 39;
        Assertions.assertEquals((float) expectedPrice/100, (float) itemPrice /100);
    }
}
