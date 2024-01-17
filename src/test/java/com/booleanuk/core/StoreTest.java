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


}
