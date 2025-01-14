package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BasketTest {
    private Basket basket;
    private Item bagel;
    private Item coffee;
    private Item filling;

    @BeforeEach
    public void setUp() {
        ArrayList<Item> basketItems = new ArrayList<>() {{
            add(bagel);
            add(coffee);
            add(filling);
        }};
        basket = new Basket(basketItems);
        basket.setCapacity(6);
        bagel = new Item("BGLS", 0.49, "Bagel", "Sesame");
        coffee = new Item("COFB", 0.99, "Coffee" , "Black");
        filling = new Item("FILX", 0.12, "Filling", "Cream Cheese");
    }

    @Test
    public void testAddItem() {
        Assertions.assertEquals("Item added successfully!",basket.addItem(coffee));
        Assertions.assertEquals("Item added successfully!",basket.addItem(bagel));
        Assertions.assertEquals("Item added successfully!",basket.addItem(filling));
    }

    @Test
    public void testAddItemToFullBasket() {
        basket.setCapacity(2);
        basket.addItem(bagel);
        basket.addItem(filling);

    }

    @Test
    public void testRemoveItem() {
        basket.addItem(coffee);
        basket.addItem(bagel);
        Assertions.assertEquals("Item removed!",basket.removeItem(coffee));
        Assertions.assertEquals("Item removed!",basket.removeItem(bagel));
        Assertions.assertEquals("Could not remove - item was never in basket", basket.removeItem(filling));
    }

    @Test
    public void testGetTotalPrice() {
        ArrayList<Item> basketItems = new ArrayList<>() {{
            add(bagel);
            add(coffee);
            add(filling);
        }};
        Assertions.assertEquals(1.60, basket.getTotalPrice(basketItems));
    }

    @Test
    public void testSetCapacity(){
        basket.setCapacity(2);
        basket.addItem(bagel);
        basket.addItem(coffee);
        Assertions.assertEquals("Basket is full!", basket.addItem(filling));
    }

}
