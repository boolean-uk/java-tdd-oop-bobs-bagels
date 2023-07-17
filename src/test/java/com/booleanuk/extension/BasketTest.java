package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.IntStream;

import static com.booleanuk.extension.SKU.*;
import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {
    @Test
    public void testAddingBagelToBasket() {
        Basket basket = new Basket();

        assertTrue(basket.addItem(new Bagel(BGLO)));
        assertTrue(basket.addItem(new Bagel(BGLO, new Filling(FILB))));
    }

    @Test
    public void testRemovingBagelFromBasket() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel(BGLO);
        basket.addItem(bagel);

        assertTrue(basket.removeItem(bagel));
    }

    @Test
    public void testCheckingIfBasketIsFull() {
        Basket basket = new Basket(2);

        basket.addItem(new Bagel(BGLO));
        assertFalse(basket.isFull());

        basket.addItem(new Bagel(BGLO));
        assertTrue(basket.isFull());
    }

    @Test
    public void testDenyingAddingBagelIfBasketIsFull() {
        Basket basket = new Basket(2);

        basket.addItem(new Bagel(BGLO));
        basket.addItem(new Bagel(BGLO));
        assertFalse(basket.addItem(new Bagel(BGLO)));
    }

    @Test
    public void testChangingBasketCapacity() {
        Basket basket = new Basket(2);

        basket.setCapacity(3);
        assertEquals(3, basket.getCapacity());

        assertThrows(IllegalArgumentException.class , () -> basket.setCapacity(-1));

        basket.addItem(new Bagel(BGLO));
        basket.addItem(new Bagel(BGLO));
        assertThrows(IllegalArgumentException.class , () -> basket.setCapacity(1));
    }

    @Test
    public void testCheckingIfBagelIsInBasket() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel(BGLO);

        assertFalse(basket.isInBasket(bagel));

        basket.addItem(bagel);
        assertTrue(basket.isInBasket(bagel));
    }

    @Test
    public void testRemovingNonexistentBagelFromBasket() {
        Basket basket = new Basket();
        assertFalse(basket.removeItem(new Bagel(BGLO)));
    }

    @Test
    public void testGettingTotalPriceOfItemsInBasket() {
        Basket basket = new Basket();
        basket.addItem(new Bagel(BGLO));
        basket.addItem(new Bagel(BGLO));

        assertEquals(BigDecimal.valueOf(0.98), basket.getTotalPrice());
    }


}
