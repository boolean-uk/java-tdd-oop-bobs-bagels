package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {


    @Test
    public void testAddItemToBaketWhichIsNotFull(){
        Basket basket = new Basket();

        Item item = new HamFilling();

        Assertions.assertEquals("Successfully added", basket.add(item));
    }

    @Test
    public void testAddItemToBaketWhichIsFull(){
        Basket basket = new Basket();

        Item item = new PlainBagel();
        basket.add(item);
        Item item1 = new SesameBagel();
        basket.add(item1);
        Item item2 = new EverythingBagel();
        basket.add(item2);
        Item item3 = new OnionBagel();
        basket.add(item3);
        Item item4 = new HamFilling();


        Assertions.assertEquals("Basket is full", basket.add(item4));
    }

    @Test
    public void testAddItemToBaketWhichDoesNotExist(){
        Basket basket = new Basket();

        Item item = new EggFilling();

        Assertions.assertEquals("Item not in inventory", basket.add(item));
    }

    @Test
    public void testRemoveExistingItemFromBasket(){
        Basket basket = new Basket();

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



        Assertions.assertTrue(basket.Resize(10));
    }

    @Test
    public void testResizeBasketToUnAcceptableSize(){
        Basket basket = new Basket();



        Assertions.assertFalse(basket.Resize(100));
    }

    @Test
    public void testCalculateTotalCostOfBasket(){
        Basket basket = new Basket();

        Item hamFilling = new HamFilling();
        basket.add(hamFilling);
        Item sesameBagel = new SesameBagel();
        basket.add(sesameBagel);

        Assertions.assertEquals(0.12 + 0.49, basket.calculateTotalCostOfBasket());
    }
}
