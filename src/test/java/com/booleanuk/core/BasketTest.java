package com.booleanuk.core;

import com.booleanuk.core.bagel.Bagel;
import com.booleanuk.core.bagel.BagelType;
import com.booleanuk.core.bagel.Filling;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BasketTest {
    private static Bagel BAGEL;
    private static Coffee COFFEE;

    @BeforeAll
    static void testSetup() {
        BAGEL = Bagel.builder()
                .type(BagelType.BGLP)
                .fillings(Filling.values())
                .build();
        COFFEE = Coffee.COFB;
    }

    @Test
    void addBagel_shouldAddBagelIfBasketNotFull() {
        var basket = new Basket(1);

        basket.addBagel(BAGEL);

        assertTrue(basket.getProducts().contains(BAGEL));
    }

    @Test
    void addBagel_shouldThrowIfBasketFull() {
        var basket = new Basket(0);

        assertThrows(IllegalStateException.class, () -> basket.addBagel(BAGEL));
    }

    @Test
    void removeBagel_shouldRemoveBagelIfPresent() {
        var basket = new Basket(1);
        basket.addBagel(BAGEL);

        basket.removeBagel(BAGEL);

        assertFalse(basket.getProducts().contains(BAGEL));
    }

    @Test
    void removeBagel_shouldThrowIfAbsent() {
        var basket = new Basket(1);

        assertThrows(NoSuchElementException.class, () -> basket.removeBagel(BAGEL));
    }

    @Test
    void addCoffee_shouldAddCoffeeIfBasketNotFull() {
        var basket = new Basket(1);

        basket.addCoffee(COFFEE);

        assertTrue(basket.getProducts().contains(COFFEE));
    }

    @Test
    void addCoffee_shouldThrowIfBasketFull() {
        var basket = new Basket(0);

        assertThrows(IllegalStateException.class, () -> basket.addCoffee(COFFEE));
    }

    @Test
    void removeCoffee_shouldRemoveCoffeeIfPresent() {
        var basket = new Basket(1);
        basket.addCoffee(COFFEE);

        basket.removeCoffee(COFFEE);

        assertFalse(basket.getProducts().contains(COFFEE));
    }

    @Test
    void removeCoffee_shouldThrowIfAbsent() {
        var basket = new Basket(1);

        assertThrows(NoSuchElementException.class, () -> basket.removeCoffee(COFFEE));
    }

    @Test
    void totalPrice_shouldReturn0ForEmptyBasket() {
        var basket = new Basket(1);

        assertEquals(BigDecimal.ZERO, basket.totalPrice());
    }

    @Test
    void totalPrice_shouldCorrectlyCalculatePriceForNonEmptyBasket() {
        var basket = new Basket(2);
        basket.addBagel(BAGEL);
        basket.addBagel(BAGEL);

        var expectedPrice = BAGEL.getPrice().multiply(BigDecimal.valueOf(2));

        assertEquals(expectedPrice, basket.totalPrice());
    }

    @Test
    void resize_shouldResizeBasketIfNewCapacityGreaterThanOrEqualsToAmountOfItems() {
        var basket = new Basket(2);
        basket.addBagel(BAGEL);
        basket.addCoffee(COFFEE);

        var newCapacity = 5;
        assertDoesNotThrow(() -> basket.resize(newCapacity));
        assertEquals(newCapacity, basket.getCapacity());
    }

    @Test
    void resize_shouldThrowIfNewCapacitySmallerThanAmountOfItems() {
        var basket = new Basket(2);
        basket.addBagel(BAGEL);
        basket.addCoffee(COFFEE);

        assertThrows(IllegalArgumentException.class, () -> basket.resize(1));
    }
}