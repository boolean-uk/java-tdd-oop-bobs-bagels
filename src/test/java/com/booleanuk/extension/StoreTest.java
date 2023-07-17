package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.stream.IntStream;

import static com.booleanuk.extension.SKU.*;
import static com.booleanuk.extension.SKU.COFB;
import static org.junit.jupiter.api.Assertions.*;

public class StoreTest {
    @Test
    public void testAddingBasketInStore() {
        Store store = new Store();
        Basket basket = new Basket();
        store.addBasket(basket);

        assertEquals(1, store.getBaskets().size());
    }

    @Test
    public void testPlacingOrderUsingSKU() {
        Store store = new Store();
        Basket basket = new Basket();
        store.addBasket(basket);

        assertNull(store.placeOrder(basket));

        basket.addItem(new Bagel(SKU.BGLO));
        basket.addItem(new Bagel(SKU.BGLO));
        assertNotNull(store.placeOrder(basket));

        assertEquals(0, store.getBaskets().size());
    }

    @Test
    public void testSpecialOffers() {
        Store store = new Store();
        Basket basket = new Basket();
        store.addBasket(basket);
        IntStream.range(0, 2).mapToObj(i -> new Bagel(BGLO)).forEach(basket::addItem);
        IntStream.range(0, 12).mapToObj(i -> new Bagel(BGLP)).forEach(basket::addItem);
        IntStream.range(0, 6).mapToObj(i -> new Bagel(BGLE)).forEach(basket::addItem);
        IntStream.range(0, 3).mapToObj(i -> new Coffee(COFB)).forEach(basket::addItem);

        UUID id = store.placeOrder(basket);
        Order order = store.getOrder(id);

        assertEquals(BigDecimal.valueOf(9.97), order.getTotalPriceAfterDiscount());
    }

    @Test
    public void testCoffeeAndBagelSpecialOffer() {
        Store store = new Store();
        Basket basket = new Basket();
        store.addBasket(basket);
        IntStream.range(0, 3).mapToObj(i -> new Bagel(SKU.BGLO)).forEach(basket::addItem);
        IntStream.range(0, 3).mapToObj(i -> new Coffee(SKU.COFB)).forEach(basket::addItem);

        UUID id = store.placeOrder(basket);
        Order order = store.getOrder(id);

        assertEquals(BigDecimal.valueOf(3.75), order.getTotalPriceAfterDiscount());
    }
}
