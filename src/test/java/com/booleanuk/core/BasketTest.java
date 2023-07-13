package com.booleanuk.core;

import com.booleanuk.core.product.Coffee;
import com.booleanuk.core.product.bagel.Bagel;
import com.booleanuk.core.product.bagel.BagelType;
import com.booleanuk.core.product.bagel.Filling;
import com.booleanuk.core.product.specialoffer.BagelOffer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BasketTest {
    private static Bagel BAGEL_ONION;
    private static Bagel BAGEL_PLAIN;
    private static Bagel BAGEL_EVERYTHING;
    private static Coffee COFFEE;

    @BeforeAll
    static void testSetup() {
        BAGEL_ONION = Bagel.builder()
                .type(BagelType.BGLO)
                .fillings(Filling.values())
                .build();
        BAGEL_PLAIN = Bagel.builder()
                .type(BagelType.BGLP)
                .fillings(Filling.values())
                .build();
        BAGEL_EVERYTHING = Bagel.builder()
                .type(BagelType.BGLE)
                .fillings(Filling.values())
                .build();
        COFFEE = Coffee.COFB;
    }

    @Test
    void addBagel_shouldAddBagelIfBasketNotFull() {
        var basket = new Basket(1);

        basket.addBagel(BAGEL_PLAIN);

        assertTrue(basket.getProducts().contains(BAGEL_PLAIN));
    }

    @Test
    void addBagel_shouldThrowIfBasketFull() {
        var basket = new Basket(0);

        assertThrows(IllegalStateException.class, () -> basket.addBagel(BAGEL_PLAIN));
    }

    @Test
    void removeBagel_shouldRemoveBagelIfPresent() {
        var basket = new Basket(1);
        basket.addBagel(BAGEL_PLAIN);

        basket.removeBagel(BAGEL_PLAIN);

        assertFalse(basket.getProducts().contains(BAGEL_PLAIN));
    }

    @Test
    void removeBagel_shouldThrowIfAbsent() {
        var basket = new Basket(1);

        assertThrows(NoSuchElementException.class, () -> basket.removeBagel(BAGEL_PLAIN));
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
    void totalPrice_shouldCorrectlyCalculatePriceForNoDiscounts() {
        var basket = new Basket(2);
        basket.addBagel(BAGEL_PLAIN);
        basket.addBagel(BAGEL_PLAIN);

        var expectedPrice = BAGEL_PLAIN.getPrice().multiply(BigDecimal.valueOf(2));

        assertEquals(expectedPrice, basket.totalPrice());
    }

    @Test
    void totalPrice_shouldCorrectlyCalculatePriceForOnionBagelOffer() {
        var cap = 6;
        var basket = new Basket(cap);
        for (int i = 0; i < cap; i++) {
            basket.addBagel(BAGEL_ONION);
        }

        var fillingPrice = Arrays.stream(BAGEL_ONION.fillings())
                .map(Filling::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        var expectedPrice = BagelOffer.Type.SixOnion.getPrice()
                .add(BigDecimal.valueOf(cap).multiply(fillingPrice));

        assertEquals(expectedPrice, basket.totalPrice());
    }

    @Test
    void totalPrice_shouldCorrectlyCalculatePriceForPlainBagelOffer() {
        var cap = 12;
        var basket = new Basket(cap);
        for (int i = 0; i < cap; i++) {
            basket.addBagel(BAGEL_PLAIN);
        }

        var fillingPrice = Arrays.stream(BAGEL_PLAIN.fillings())
                .map(Filling::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        var expectedPrice = BagelOffer.Type.TwelvePlain.getPrice()
                .add(BigDecimal.valueOf(cap).multiply(fillingPrice));

        assertEquals(expectedPrice, basket.totalPrice());
    }

    @Test
    void totalPrice_shouldCorrectlyCalculatePriceForEverythingBagelOffer() {
        var cap = 6;
        var basket = new Basket(cap);
        for (int i = 0; i < cap; i++) {
            basket.addBagel(BAGEL_EVERYTHING);
        }

        var fillingPrice = Arrays.stream(BAGEL_EVERYTHING.fillings())
                .map(Filling::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        var expectedPrice = BagelOffer.Type.SixEverything.getPrice()
                .add(BigDecimal.valueOf(cap).multiply(fillingPrice));

        assertEquals(expectedPrice, basket.totalPrice());
    }

    @Test
    void totalPrice_shouldCorrectlyCalculatePriceForBreakfastOffer() {
        var basket = new Basket(2);
        basket.addBagel(BAGEL_EVERYTHING);
        basket.addCoffee(COFFEE);

        var fillingPrice = Arrays.stream(BAGEL_EVERYTHING.fillings())
                .map(Filling::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        var expectedPrice = BigDecimal.valueOf(1.25)
                .add(fillingPrice);

        assertEquals(expectedPrice, basket.totalPrice());
    }

    @Test
    void resize_shouldResizeBasketIfNewCapacityGreaterThanOrEqualsToAmountOfItems() {
        var basket = new Basket(2);
        basket.addBagel(BAGEL_PLAIN);
        basket.addCoffee(COFFEE);

        var newCapacity = 5;
        assertDoesNotThrow(() -> basket.resize(newCapacity));
        assertEquals(newCapacity, basket.getCapacity());
    }

    @Test
    void resize_shouldThrowIfNewCapacitySmallerThanAmountOfItems() {
        var basket = new Basket(2);
        basket.addBagel(BAGEL_PLAIN);
        basket.addCoffee(COFFEE);

        assertThrows(IllegalArgumentException.class, () -> basket.resize(1));
    }
}