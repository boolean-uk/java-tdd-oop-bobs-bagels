package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasketTest {
    private Basket basket;
    private Bagel bagel;
    private Coffee coffee;
    private Filling filling;
    @BeforeEach
    void setUp(){
        basket = new Basket(3);
        bagel = new Bagel("BGLO","Onion",0.49);
        coffee = new Coffee("COFB","Black",0.99);
        filling = new Filling("FILB","Bacon",0.12);
    }
    @Test
    public void testAddNoItemIntoBasket(){
        Assertions.assertEquals("Basket is empty",basket.addItem(null));
    }
    @Test
    public void testAddItem(){
        basket.addItem(bagel);
        Assertions.assertEquals(1, basket.getItemBasket().size());

        basket.addItem(coffee);
        Assertions.assertEquals(2, basket.getItemBasket().size());

        basket.addItem(filling);
        Assertions.assertEquals(3, basket.getItemBasket().size());
    }

    @Test
    public void testAddItemIfBasketIsFull(){
        basket.addItem(bagel);
        basket.addItem(bagel);
        basket.addItem(bagel);
        Assertions.assertEquals("Can't add anymore, basket is full", basket.addItem(bagel));
    }

    @Test
    public void testRemoveItemFromBasket(){
        basket.addItem(bagel);
        basket.addItem(coffee);
        Assertions.assertEquals("Item has been removed from your basket", basket.removeItem(bagel));
    }

    @Test
    public void testRemoveNonExistingItem(){
        basket.addItem(bagel);
        Assertions.assertEquals("Can not remove non-existing item.", basket.removeItem(coffee));
    }

    @Test
    public void testCalculateTotalCost(){
        basket.addItem(bagel);
        basket.addItem(coffee);
        basket.addItem(filling);
        Assertions.assertEquals(1.6, basket.calculateTotalCost());
    }

}
