package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {
    @Test
    public void testAddingBagelToBasket() {
        Basket basket = new Basket();

        assertTrue(basket.addItem(new Bagel(Bagel.BagelType.PLAIN)));
    }

    @Test
    public void testRemovingBagelFromBasket() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel(Bagel.BagelType.PLAIN);
        basket.addItem(bagel);

        assertTrue(basket.removeItem(bagel.getId()));
    }

    @Test
    public void testCheckingIfBasketIsFull() {
        Basket basket = new Basket(2);

        basket.addItem(new Bagel(Bagel.BagelType.PLAIN));
        assertFalse(basket.isFull());

        basket.addItem(new Bagel(Bagel.BagelType.PLAIN));
        assertTrue(basket.isFull());
    }

    @Test
    public void testDenyingAddingBagelIfBasketIsFull() {
        Basket basket = new Basket(2);

        basket.addItem(new Bagel(Bagel.BagelType.PLAIN));
        basket.addItem(new Bagel(Bagel.BagelType.PLAIN));
        assertFalse(basket.addItem(new Bagel(Bagel.BagelType.PLAIN)));
    }

    @Test
    public void testChangingBasketCapacity() {
        Basket basket = new Basket(2);

        basket.setCapacity(3);
        assertEquals(3, basket.getCapacity());

        assertThrows(IllegalArgumentException.class , () -> basket.setCapacity(-1));

        basket.addItem(new Bagel(Bagel.BagelType.PLAIN));
        basket.addItem(new Bagel(Bagel.BagelType.PLAIN));
        assertThrows(IllegalArgumentException.class , () -> basket.setCapacity(1));
    }

    @Test
    public void testCheckingIfBagelIsInBasket() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel(Bagel.BagelType.PLAIN);

        assertFalse(basket.isInBasket(bagel));

        basket.addItem(bagel);
        assertTrue(basket.isInBasket(bagel));
    }

    @Test
    public void testRemovingNonexistentBagelFromBasket() {
        Basket basket = new Basket();
        assertFalse(basket.removeItem(UUID.randomUUID()));
    }
}
