package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
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

    @Test
    public void testCheckingBagelPrice() {
        assertEquals(BigDecimal.valueOf(0.49), Basket.checkPrice(new Bagel(BGLO)));
        assertEquals(BigDecimal.valueOf(0.61), Basket.checkPrice(new Bagel(BGLO, new Filling(FILB))));
    }

    @Test
    public void testAddingFillingToBagel() {
        Bagel bagel = new Bagel(BGLO);

        assertTrue(bagel.addFilling(new Filling(FILB)));
        assertFalse(bagel.addFilling(new Filling(FILB)));
    }

    @Test
    public void testGettingAvailableFillings() {
        Basket basket = new Basket();
        assertEquals(6, basket.getAvailableFillings().size());
    }

    @Test
    public void testCheckingPriceOfFilling() {
        assertEquals(BigDecimal.valueOf(0.12), Basket.checkPrice(new Filling(FILB)));
    }

    @Test
    public void testCreatingItemUsingStrings() {
        Bagel bagel = new Bagel("Onion", new Filling("Bacon"));
        assertNotNull(bagel);
    }

    @Test
    public void testOrderingItemOutOfInventory() {
        assertThrows(IllegalArgumentException.class, () -> new Bagel("Incorrect"));
    }

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
    public void testGettingTotalPriceOfOrder() {
        Store store = new Store();
        Basket basket = new Basket();
        store.addBasket(basket);
        basket.addItem(new Bagel(BGLO));
        basket.addItem(new Bagel(BGLO));

        assertEquals(BigDecimal.valueOf(0.98), basket.getTotalPrice());
    }

    @Test
    public void testCountingItemQuantityForDiscount() {
        Store store = new Store();
        Basket basket = new Basket();
        store.addBasket(basket);
        basket.addItem(new Bagel(BGLO));
        basket.addItem(new Bagel(BGLO));
        UUID id = store.placeOrder(basket);
        assertNotNull(store.getOrder(id));

        assertEquals(BigDecimal.valueOf(2), store.getOrder(id).getTotalPriceAfterDiscount());
    }

    @Test
    public void testSpecialOffers() {
        Store store = new Store();
        Basket basket = new Basket();
        store.addBasket(basket);
        basket.addItem(new Bagel(BGLO));
        basket.addItem(new Bagel(BGLO));
        for (int i = 0; i < 6; i++) {
            basket.addItem(new Bagel(BGLP));
            basket.addItem(new Bagel(BGLP));
            basket.addItem(new Bagel(BGLE));
        }
        for (int i = 0; i < 3; i++) {
            basket.addItem(new Bagel(COFB));
        }
        UUID id = store.placeOrder(basket);
        Order order = store.getOrder(id);



        assertEquals(23, order.getItems().values().stream().mapToInt(Integer::intValue).sum());
//        assertEquals(BigDecimal.valueOf(11.57), basket.getTotalPrice());
//        assertEquals(BigDecimal.valueOf(9.27), order.getTotalPriceAfterDiscount());
    }
}