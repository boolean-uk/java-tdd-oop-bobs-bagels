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
        for(int i = 0; i < 100; i++){

            basket.add(item, menu);
        }




        Assertions.assertEquals("Basket is full", basket.add(item, menu));
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


}
