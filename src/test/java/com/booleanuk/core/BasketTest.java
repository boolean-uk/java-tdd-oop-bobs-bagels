package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static com.booleanuk.core.SKU.BGLO;
import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {
    @Test
    public void testAddingItemToBasket() {
        Basket basket = new Basket();

        assertTrue(basket.addItem(new Item(BGLO)));
    }

    @Test
    public void testRemovingBagelFromBasket() {
        Basket basket = new Basket();
        Item bagel = new Item(BGLO);
        basket.addItem(bagel);

        assertTrue(basket.removeItem(bagel));
    }

    @Test
    public void testCheckingIfBasketIsFull() {
        Basket basket = new Basket(2);

        basket.addItem(new Item(BGLO));
        assertFalse(basket.isFull());

        basket.addItem(new Item(BGLO));
        assertTrue(basket.isFull());
    }

    @Test
    public void testDenyingAddingBagelIfBasketIsFull() {
        Basket basket = new Basket(2);

        basket.addItem(new Item(BGLO));
        basket.addItem(new Item(BGLO));
        assertFalse(basket.addItem(new Item(BGLO)));
    }

    @Test
    public void testChangingBasketCapacity() {
        Basket basket = new Basket(2);

        basket.setCapacity(3);
        assertEquals(3, basket.getCapacity());

        assertThrows(IllegalArgumentException.class , () -> basket.setCapacity(-1));

        basket.addItem(new Item(BGLO));
        basket.addItem(new Item(BGLO));
        assertThrows(IllegalArgumentException.class , () -> basket.setCapacity(1));
    }

    @Test
    public void testCheckingIfBagelIsInBasket() {
        Basket basket = new Basket();
        Item item = new Item(BGLO);

        assertFalse(basket.isInBasket(item));

        basket.addItem(item);
        assertTrue(basket.isInBasket(item));
    }

    @Test
    public void testRemovingNonexistentBagelFromBasket() {
        Basket basket = new Basket();
        assertFalse(basket.removeItem(new Item(BGLO)));
    }

    @Test
    public void testGettingTotalPriceOfItemsInBasket() {
        Basket basket = new Basket();
        basket.addItem(new Item(BGLO));
        basket.addItem(new Item(BGLO));

        assertEquals(0.78, basket.getTotalPrice());
    }
}
