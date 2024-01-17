package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    public void addingItemShouldReturnTrue(){
        Basket basket = new Basket( 4);
        Assertions.assertTrue(basket.add((new Bagel("BGLO",0.49, "Bagel", "onion"))));
        Assertions.assertTrue(basket.add((new Bagel("BGLP", 0.39, "Bagel", "Plain"))));
    }
    @Test
    public void addingItemShouldReturnFalse(){
        Basket basket = new Basket( 4);
        basket.add(new Bagel("BGLO",0.49, "Bagel", "Onion" ));
        boolean result =  basket.add(new Bagel("BGLO",0.49, "Bagel", "Onion" ));
        Assertions.assertFalse(result);

    }
    @Test
    public void removingItemWhenItemIsInBasket(){
        Basket basket = new Basket(4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        Bagel bagel2 = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        basket.add(bagel1);
        basket.add(bagel2);
        Assertions.assertEquals("Onion Bagel removed from basket", basket.remove(bagel1));
    }
    @Test
    public void removingItemWhenBasketIsEmpty(){
        Basket basket = new Basket(4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        basket.add(bagel1);
        basket.remove(bagel1);
        Assertions.assertEquals("Basket is empty", basket.remove(bagel1));
    }
    @Test
    public void isFullShouldReturnTrue(){
        Basket basket = new Basket(4);
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
        Basket basket = new Basket(4);
        Assertions.assertEquals("Basket size is updated to 8", basket.changeCapacity(8));
    }
    @Test
    public void removingItemNotInBasket(){
        Basket basket = new Basket(4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        Bagel bagel2 = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        basket.add(bagel1);
        Assertions.assertEquals("Plain Bagel is not in the basket!", basket.remove(bagel2));
    }
    @Test
    public void shouldReTurnTotalCost(){
        Basket basket = new Basket(4);
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", "Onion" );
        Bagel bagel2 = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        basket.add(bagel1);
        basket.add(bagel2);
        Assertions.assertEquals(0.88, basket.getTotalCost());
    }
}
