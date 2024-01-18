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

    @Test
    public void addFillingThatAllGivenBagelsAlreadyHaveTest() {
        Store store = new Store();
        int basketId = store.createBasket();

        store.addBagelToBasket("Onion", basketId);
        store.addBagelToBasket("Onion", basketId);

        store.addFilling("Cheese", "Onion", basketId);
        store.addFilling("Cheese", "Onion", basketId);
        store.addFilling("Egg", "Onion", basketId);

        String actual = store.addFilling("Cheese", "Onion", basketId);

        Assertions.assertEquals("All bagels of that kind in your basket already has that filling.", actual);
    }

    @Test
    public void updateBasketCapacityToValid() {
        Store store = new Store();
        int basketId = store.createBasket();

        store.addBagelToBasket("Onion", basketId);
        store.addBagelToBasket("Onion", basketId);

        basketId = store.createBasket();

        store.addBagelToBasket("Onion", basketId);

        Assertions.assertTrue(store.updateBasketCapacity(2));
    }

    @Test
    public void updateBasketCapacityToInvalid() {
        Store store = new Store();
        int basketId = store.createBasket();

        store.addBagelToBasket("Onion", basketId);
        store.addBagelToBasket("Onion", basketId);
        store.addBagelToBasket("Onion", basketId);

        basketId = store.createBasket();

        store.addBagelToBasket("Onion", basketId);

        Assertions.assertFalse(store.updateBasketCapacity(2));
    }

    @Test
    public void getCostOfInvalidBagelTest() {
        Store store = new Store();
        Assertions.assertEquals(-1, store.getCostOfBagel("Chocolate"));
    }

    @Test
    public void getCostOfValidBagelTest() {
        Store store = new Store();
        Assertions.assertEquals(0.49, store.getCostOfBagel("Onion"));
    }

    @Test
    public void getCostOfInvalidFillingTest() {
        Store store = new Store();
        Assertions.assertEquals(-1, store.getCostOfFilling("Chocolate"));
    }

    @Test
    public void getCostOfValidFillingTest() {
        Store store = new Store();
        Assertions.assertEquals(0.12, store.getCostOfFilling("cheese"));
    }

    @Test
    public void getCostOfEmptyBasketTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        Assertions.assertEquals(0, store.getCostOfBasket(basketId));
    }

    @Test
    public void getCostOfBasketContainingOnlyBagelsTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        store.addBagelToBasket("Onion", basketId);
        store.addBagelToBasket("Plain", basketId);
        Assertions.assertEquals(0.49+0.39, store.getCostOfBasket(basketId));
    }

    @Test
    public void getCostOfBasketContainingBagelsAndFillingsTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        store.addBagelToBasket("Onion", basketId);
        store.addFilling("egg", "onion", basketId);
        store.addBagelToBasket("Plain", basketId);
        store.addFilling("cheese", "onion", basketId);
        store.addFilling("cheese", "Plain", basketId);
        Assertions.assertEquals(0.49+0.39+3*0.12, store.getCostOfBasket(basketId));
    }

}
