package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    public void addItemToBasket(){
        Basket basket = new Basket( 5);
        Assertions.assertTrue(basket.addItem((new Bagel("BGLO",0.49, "Bagel", "Onion"))));
        Assertions.assertTrue(basket.addItem((new Bagel("BGLO",0.49, "Bagel", "Onion"))));
        Assertions.assertTrue(basket.addItem((new Bagel("BGLP", 0.39, "Bagel", "Plain"))));
        Assertions.assertFalse(basket.addItem((new Bagel("BGL", 0.19, "test", "test"))));

    }
    @Test
    public void removingItemWhenItemIsInBasket(){
        Basket basket = new Basket( 4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        Bagel bagel2 = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        basket.addItem(bagel1);
        basket.addItem(bagel2);
        Assertions.assertEquals("Onion Bagel removed from basket", basket.remove(bagel1));
    }
    @Test
    public void removingItemWhenItemNotInBasket(){
        Basket basket = new Basket( 4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        Bagel bagel2 = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        basket.addItem(bagel1);
        Assertions.assertEquals("Plain Bagel is not in the basket!", basket.remove(bagel2));
    }
    @Test
    public void isFullShouldReturnTrue(){
        Basket basket = new Basket( 4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        Bagel bagel2 = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        Bagel bagel3 = new Bagel("BGLE", 0.49, "Bagel", "Everything" );
        Bagel bagel4 = new Bagel("BGLS", 0.49, "Bagel", "Sesame" );
        basket.addItem(bagel1);
        basket.addItem(bagel2);
        basket.addItem(bagel3);
        basket.addItem(bagel4);
        Assertions.assertTrue(basket.isFull());
    }
    @Test
    public void isFullShouldReturnFalse(){
        Basket basket = new Basket( 4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        Bagel bagel2 = new Bagel("BGLP", 0.39, "Bagel", "Plain");

        basket.addItem(bagel1);
        basket.addItem(bagel2);

        Assertions.assertFalse(basket.isFull());
    }
    @Test
    public void shouldChangeBasketCapacity(){
        Basket basket = new Basket( 4);
        Assertions.assertEquals("Basket size is updated to 8", basket.changeCapacity(8));
    }
    @Test
    public void removingItemNotInBasket(){
        Basket basket = new Basket( 4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        Bagel bagel2 = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        basket.addItem(bagel1);
        Assertions.assertEquals("Plain Bagel is not in the basket!", basket.remove(bagel2));
    }
    @Test
    public void shouldReTurnTotalCost(){
        Basket basket = new Basket( 4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        Bagel bagel2 = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        Filling filling = new Filling("FILB",0.12, "Filling", "Bacon");

        basket.addItem(bagel1);
        basket.addItem(bagel2);
        basket.addingFillingWhenBagelInBasket(filling);

        Assertions.assertEquals(1.0, basket.getTotalCost());


    }
    @Test
    public void shouldReturnItemCost(){
        Basket basket = new Basket(  4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        Bagel bagel2 = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        Assertions.assertEquals(0.49, basket.getItemCost(bagel1));
        Assertions.assertEquals(0.39, basket.getItemCost(bagel2));
        Assertions.assertNotEquals(0.19, basket.getItemCost(bagel1));
        Assertions.assertNotEquals(0.29, basket.getItemCost(bagel2));
    }
    @Test
    public void shouldaddItemFillingToBasket(){
        Basket basket = new Basket(4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        basket.addItem(bagel1);
        Filling filling = new Filling("FILB",0.12, "Filling", "Bacon");
        Assertions.assertEquals("Bacon Filling is added", basket.addingFillingWhenBagelInBasket(filling));
    }
    @Test
    public void shouldNotAddFillingWhenNoBagelInBasket(){
        Basket basket = new Basket(4);
        Filling filling = new Filling("FILB",0.12, "Filling", "Bacon");
        Assertions.assertEquals("Please select a bagel before adding filling", basket.addingFillingWhenBagelInBasket(filling));
    }
    @Test
    public void shouldReturnFillingCost(){
        Basket basket = new Basket( 4);
        Filling filling1 = new Filling("FILB",0.12, "Filling", "Bacon");
        Filling filling2 = new Filling("FILC",0.12, "Filling", "Cheese");
        Assertions.assertEquals(0.12, basket.getFillingCost(filling1));
        Assertions.assertEquals(0.12, basket.getFillingCost(filling2));
    }

    @Test
    public void isItemInInventoryShouldReturnTrue(){
        Basket basket = new Basket( 4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        Bagel bagel2 = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        Assertions.assertTrue(basket.isItemInInventory(bagel1));
        Assertions.assertTrue(basket.isItemInInventory(bagel2));
    }
    @Test
    public void isItemInInventoryShouldReturnFalse(){
        Basket basket = new Basket( 4);
        Bagel bagel1 = new Bagel("BGL",0.49, "Bagel", "Onion" );
        Bagel bagel2 = new Bagel("BGL", 0.39, "Bagel", "Plain");
        Assertions.assertFalse(basket.isItemInInventory(bagel1));
        Assertions.assertFalse(basket.isItemInInventory(bagel2));
    }
}
