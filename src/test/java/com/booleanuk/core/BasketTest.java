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
        Bagel bagel = new Bagel("BGLO");
        Bagel bagel2 = new Bagel("BGLO");
        Coffee coffee = new Coffee("COFB");
        Filling filling = new Filling("FILH");
        basket.addItemToBasket(bagel);
        basket.addItemToBasket(coffee);
        basket.addItemToBasket(filling);


        //Populate a reference list
        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(bagel);
        itemList.add(coffee);
        itemList.add(filling);

        System.out.println(basket.checkAllItems());

        for (int i = 0; i < basket.countTotalItems(); i++) {
            Assertions.assertEquals(1, basket.checkAllItems().get(itemList.get(i).getSKU()));
        }
    }

    @Test
    public void addMultipleBagels() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel("BGLO");
        Bagel bagel2 = new Bagel("BGLO");
        basket.addItemToBasket(bagel);
        basket.addItemToBasket(bagel2);


        //Populate a reference list
        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(bagel);
        itemList.add(bagel2);

        for (int i = 0; i < basket.countTotalItems(); i++) {
            Assertions.assertEquals(2, basket.checkAllItems().get(itemList.get(i).getSKU()));
        }
    }

    @Test
    public void addFillingToBagelTest() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel("BGLO");
        Filling filling = new Filling("FILX");

        bagel.addFilling(filling);
        basket.addItemToBasket(bagel);
        basket.addItemToBasket(filling);

        Assertions.assertEquals(2, basket.countTotalItems());

        Assertions.assertEquals(1, basket.getItemQuantityFromSKU(bagel.getSKU()));

    }

    @Test
    public void calculateTotalValueOfBasketTest() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel("BGLO");
        Filling filling = new Filling("FILX");
        Bagel bagel2 = new Bagel("BGLP");

        bagel.addFilling(filling);
        basket.addItemToBasket(bagel);
        basket.addItemToBasket(filling);

        Assertions.assertEquals(2, basket.countTotalItems());

        Assertions.assertEquals(0.61, basket.countTotalValueOfItems());

        basket.addItemToBasket(bagel2);

        Assertions.assertEquals(1.0, basket.countTotalValueOfItems());
    }

    @Test
    public void removeItemFromBasketTest() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel("BGLO");
        Filling filling = new Filling("FILX");
        Bagel bagel2 = new Bagel("BGLP");
        bagel.addFilling(filling);
        basket.addItemToBasket(bagel);
        basket.addItemToBasket(filling);
        basket.addItemToBasket(bagel2);

        Assertions.assertEquals(3, basket.countTotalItems());

        basket.removeItemFromBasket(bagel);
        basket.removeItemFromBasket(bagel2);

        Assertions.assertEquals(0, basket.countTotalItems());
    }

    @Test
    public void removeOneOfTwoBagelsTest() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel("BGLO");
        Filling filling = new Filling("FILX");
        Bagel bagel2 = new Bagel("BGLO");
        Filling filling2 = new Filling("FILB");
        basket.addItemToBasket(bagel, filling);
        basket.addItemToBasket(bagel2, filling2);

        Assertions.assertEquals(4, basket.countTotalItems());

        basket.removeItemFromBasket(bagel);

        Assertions.assertEquals(2, basket.countTotalItems());

    }
}
