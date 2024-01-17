package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StoreTest {

    @Test
    public void createBasketTest() {
        Store store = new Store();
        Assertions.assertEquals(0, store.getBaskets().size());
        int basketId = store.createBasket();
        Assertions.assertEquals(1, store.getBaskets().size());
        Assertions.assertEquals(basketId, store.getBaskets().get(basketId).hashCode());
    }

    @Test
    public void addExistingBagelToBasketTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        Bagel bagel = new Bagel("Onion");
        Assertions.assertFalse(store.getBaskets().get(basketId).getBagels().contains(bagel));
        String actual = store.addBagelToBasket("Onion", basketId);
        Assertions.assertEquals("Bagel added.", actual);
        Assertions.assertTrue(store.getBaskets().get(basketId).getBagels().contains(bagel));
    }

    @Test
    public void addNonExistingBagelToBasketTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        Bagel bagel = new Bagel("Orange");
        Assertions.assertFalse(store.getBaskets().get(basketId).getBagels().contains(bagel));
        String actual = store.addBagelToBasket("Orange", basketId);
        Assertions.assertEquals("Bob's bagels doesn't have that bagel.", actual);
        Assertions.assertFalse(store.getBaskets().get(basketId).getBagels().contains(bagel));
    }

    @Test
    public void addBagelToFullBasketTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        store.addBagelToBasket("Onion", basketId);
        store.addBagelToBasket("Onion", basketId);
        store.addBagelToBasket("Onion", basketId);
        String actual = store.addBagelToBasket("Onion", basketId);
        Assertions.assertEquals("You're basket is full!", actual);
    }

    @Test
    public void addNonExistentFillingToBagelInBasket() {
        Store store = new Store();
        int basketId = store.createBasket();
        store.addBagelToBasket("Onion", basketId);
        String actual = store.addFilling("Lettuce", "Onion", basketId);
        Assertions.assertEquals("Bob's bagels doesn't have that filling.", actual);
    }


}
