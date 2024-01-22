package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasketTest {
    private Basket basket;
    private Bagel bagel;
    private Coffee coffee;
    private Filling filling;

    private Inventory inventory;
    @BeforeEach
    void setUp(){
        inventory = new Inventory();
        basket = new Basket(inventory, 3);
        bagel = new Bagel("BGLO", "Onion", 0.49);
        coffee = new Coffee("COFB","Black", 0.99);
        filling = new Filling("FILE","Egg",0.12);
        inventory.addToMenu(bagel,10);
        inventory.addToMenu(coffee,15);
        inventory.addToMenu(filling,20);
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
    public void testDecreaseStockWhenAdded(){
        Assertions.assertEquals(10, inventory.getInventory(bagel.getSku()));
        basket.addItem(bagel);
        Assertions.assertEquals(9, inventory.getInventory(bagel.getSku()));
        basket.addItem(bagel);
        Assertions.assertEquals(8, inventory.getInventory(bagel.getSku()));
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

    @Test
    public void testChangeCapacity(){
        basket.addItem(bagel);
        basket.addItem(bagel);
        basket.addItem(bagel);
        Assertions.assertEquals("Can't add anymore, basket is full", basket.addItem(bagel));
        basket.changeCapacity(8);
        basket.addItem(coffee);
        basket.addItem(coffee);
        Assertions.assertEquals(5, basket.getItemBasket().size());
    }

    @Test
    public void testAddFillingToBagel(){
        basket.addBagelWithFilling(bagel, filling);
        Assertions.assertEquals(2, basket.getItemBasket().size());
    }
    @Test
    public void testOutOfStock(){
        Filling bacon = new Filling("FILB","Bacon",0.12);
        inventory.addToMenu(bacon,0);
        Assertions.assertEquals(0, inventory.getInventory("FILB"));
        Assertions.assertEquals("Out of Stock", basket.addItem(bacon));
    }

    @Test
    public void testSeeCurrentBsket(){
        basket.addItem(bagel);
        basket.addItem(bagel);
        basket.addItem(coffee);
        Assertions.assertEquals("BGLO: Bagel - Onion           $0.49\n" +
                "BGLO: Bagel - Onion           $0.49\n" +
                "COFB: Coffee - Black           $0.99\n", basket.currentBasketToString());
        System.out.println(basket.currentBasketToString());
    }
}
