package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    public void addingItemShouldReturnTrue(){
        Inventory inventory = new Inventory();
        Basket basket = new Basket( inventory, 4);
        Assertions.assertTrue(basket.add((new Bagel("BGLO",0.49, "Bagel", "onion"))));
        Assertions.assertTrue(basket.add((new Bagel("BGLP", 0.39, "Bagel", "Plain"))));
    }
    @Test
    public void addingItemShouldReturnFalse(){
        Inventory inventory = new Inventory();
        Basket basket = new Basket( inventory, 4);
        basket.add(new Bagel("BGLO",0.49, "Bagel", "Onion" ));
        boolean result =  basket.add(new Bagel("BGLO",0.49, "Bagel", "Onion" ));
        Assertions.assertFalse(result);

    }
    @Test
    public void removingItemWhenItemIsInBasket(){
        Inventory inventory = new Inventory();
        Basket basket = new Basket( inventory, 4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        Bagel bagel2 = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        basket.add(bagel1);
        basket.add(bagel2);
        Assertions.assertEquals("Onion Bagel removed from basket", basket.remove(bagel1));
    }
    @Test
    public void removingItemWhenBasketIsEmpty(){
        Inventory inventory = new Inventory();
        Basket basket = new Basket( inventory, 4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        basket.add(bagel1);
        basket.remove(bagel1);
        Assertions.assertEquals("Basket is empty", basket.remove(bagel1));
    }
    @Test
    public void isFullShouldReturnTrue(){
        Inventory inventory = new Inventory();
        Basket basket = new Basket( inventory, 4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        Bagel bagel2 = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        Bagel bagel3 = new Bagel("BGLE", 0.49, "Bagel", "Everything" );
        Bagel bagel4 = new Bagel("BGLS", 0.49, "Bagel", "Sesame" );
        basket.add(bagel1);
        basket.add(bagel2);
        basket.add(bagel3);
        basket.add(bagel4);
        Assertions.assertTrue(basket.isFull());
    }
    @Test
    public void shouldChangeBasketCapacity(){
        Inventory inventory = new Inventory();
        Basket basket = new Basket( inventory, 4);
        Assertions.assertEquals("Basket size is updated to 8", basket.changeCapacity(8));
    }
    @Test
    public void removingItemNotInBasket(){
        Inventory inventory = new Inventory();
        Basket basket = new Basket( inventory, 4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        Bagel bagel2 = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        basket.add(bagel1);
        Assertions.assertEquals("Plain Bagel is not in the basket!", basket.remove(bagel2));
    }
    @Test
    public void shouldReTurnTotalCost(){
        Inventory inventory = new Inventory();
        Basket basket = new Basket( inventory, 4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        Bagel bagel2 = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        basket.add(bagel1);
        basket.add(bagel2);
        Assertions.assertEquals(0.88, basket.getTotalCost());
    }
    @Test
    public void shouldReturnItemCost(){
        Inventory inventory = new Inventory();
        Basket basket = new Basket( inventory, 4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        Bagel bagel2 = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        Assertions.assertEquals(0.49, basket.getItemCost(bagel1));
        Assertions.assertEquals(0.39, basket.getItemCost(bagel2));
        Assertions.assertNotEquals(0.19, basket.getItemCost(bagel1));
        Assertions.assertNotEquals(0.29, basket.getItemCost(bagel2));
    }
    @Test
    public void shouldAddFillingToBasket(){
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory,4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        basket.add(bagel1);
        Filling filling = new Filling("FILB",0.12, "Filling", "Bacon");
        Assertions.assertEquals("Bacon Filling is added", basket.addingFillingWhenBagelInBasket(filling));
    }
    @Test
    public void shouldNotAddFillingWhenNoBagelInBasket(){
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory,4);
        Filling filling = new Filling("FILB",0.12, "Filling", "Bacon");
        Assertions.assertEquals("Please select a bagel before adding filling", basket.addingFillingWhenBagelInBasket(filling));
    }
    @Test
    public void shouldReturnFillingCost(){
        Inventory inventory = new Inventory();
        Basket basket = new Basket( inventory, 4);
        Filling filling1 = new Filling("FILB",0.12, "Filling", "Bacon");
        Filling filling2 = new Filling("FILC",0.12, "Filling", "Cheese");
        Assertions.assertEquals(0.12, basket.getFillingCost(filling1));
        Assertions.assertEquals(0.12, basket.getFillingCost(filling2));
    }

}
