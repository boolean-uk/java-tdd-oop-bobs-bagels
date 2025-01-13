package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {


    @Test
    public void testAddItemToBasketWhichIsNotFull(){
        Basket basket = new Basket();
        Menu menu = new Menu();

        Item item = new HamFilling();

        Assertions.assertEquals("Successfully added", basket.add(item, menu));
    }

    @Test
    public void testAddItemToBasketWhichIsFull(){
        Basket basket = new Basket();
        Menu menu = new Menu();

        Item item = new PlainBagel();
        basket.add(item, menu);
        Item item1 = new SesameBagel();
        basket.add(item1, menu);
        Item item2 = new EverythingBagel();
        basket.add(item2, menu);
        Item item3 = new OnionBagel();
        basket.add(item3, menu);
        Item item4 = new HamFilling();


        Assertions.assertEquals("Basket is full", basket.add(item4, menu));
    }

    @Test
    public void testAddItemTosBaketWhichDoesNotExist(){
        Basket basket = new Basket();
        Menu menu = new Menu();

        Item item = new EggFilling();

        Assertions.assertEquals("Item not on the menu", basket.add(item, menu));
    }

    @Test
    public void testRemoveExistingItemFromBasket(){
        Basket basket = new Basket();
        Menu menu = new Menu();
        Item ham = new HamFilling();
        basket.add(ham, menu);

        String item = "Ham";

        Assertions.assertEquals("Successfully removed", basket.remove(item));
    }

    @Test
    public void testRemoveNonExistingItemFromBasket(){
        Basket basket = new Basket();

        String item = "Sausage";

        Assertions.assertEquals("No item found", basket.remove(item));
    }

    @Test
    public void testResizeBasketToAcceptableSize(){
        Basket basket = new Basket();



        Assertions.assertTrue(basket.resizeBasket(10));
    }

    @Test
    public void testResizeBasketToUnAcceptableSize(){
        Basket basket = new Basket();



        Assertions.assertFalse(basket.resizeBasket(100));
    }

    @Test
    public void testCalculateTotalCostOfBasket(){
        Basket basket = new Basket();
        Menu menu = new Menu();

        Item hamFilling = new HamFilling();
        basket.add(hamFilling, menu);
        Item sesameBagel = new SesameBagel();
        basket.add(sesameBagel, menu);
        Item sesameBagel2 = new SesameBagel();
        basket.add(sesameBagel2, menu);

        Assertions.assertEquals(0.12 + 0.49 * 2, basket.calculateTotalCostOfBasket());
    }

    @Test
    public void testCalculateTotalCostOfBasketWithDiscounts(){
        Basket basket = new Basket();
        Menu menu = new Menu();

        Item item1 = new OnionBagel();
        basket.add(item1, menu);
        Item item2 = new OnionBagel();
        basket.add(item2, menu);
        Item item3 = new PlainBagel();
        basket.add(item3, menu);
        Item item4 = new PlainBagel();
        basket.add(item4, menu);
        Item item5 = new PlainBagel();
        basket.add(item5, menu);
        Item item6 = new PlainBagel();
        basket.add(item6, menu);
        Item item7 = new PlainBagel();
        basket.add(item7, menu);
        Item item8 = new PlainBagel();
        basket.add(item8, menu);
        Item item9 = new PlainBagel();
        basket.add(item9, menu);
        Item item10 = new PlainBagel();
        basket.add(item10, menu);
        Item item11 = new PlainBagel();
        basket.add(item11, menu);
        Item item12 = new PlainBagel();
        basket.add(item12, menu);
        Item item13 = new PlainBagel();
        basket.add(item13, menu);
        Item item14 = new PlainBagel();
        basket.add(item14, menu);
        Item item15 = new EverythingBagel();
        basket.add(item15, menu);
        Item item16 = new EverythingBagel();
        basket.add(item16, menu);
        Item item17 = new EverythingBagel();
        basket.add(item17, menu);
        Item item18 = new EverythingBagel();
        basket.add(item18, menu);
        Item item19 = new EverythingBagel();
        basket.add(item19, menu);
        Item item20 = new EverythingBagel();
        basket.add(item20, menu);
        Item item21 = new CappuccinoCoffee();
        basket.add(item21, menu);
        Item item22 = new BlackCoffee();
        basket.add(item22, menu);
        Item item23 = new WhiteCoffee();
        basket.add(item23, menu);

        Assertions.assertEquals(10.43, basket.calculateTotalCostOfBasketWithDiscounts());

        Basket basket1 = new Basket();

        for(int i = 0; i < 16; i++){
            Item plainBagel = new PlainBagel();
            basket.add(plainBagel, menu);
        }

        Assertions.assertEquals(5.55, basket.calculateTotalCostOfBasketWithDiscounts());
    }
}
