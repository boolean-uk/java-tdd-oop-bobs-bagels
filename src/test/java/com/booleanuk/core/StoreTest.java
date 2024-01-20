package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Assertions.assertFalse(store.getBaskets().get(basketId).getItems().contains(bagel));
        String actual = store.addItemToBasket(bagel, basketId);
        Assertions.assertEquals("Onion Bagel added.", actual);
        System.out.println(store.getBaskets().get(basketId).getItems());
        Assertions.assertTrue(store.getBaskets().get(basketId).getItems().contains(bagel));
    }

    @Test
    public void addNonExistingBagelToBasketTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        Bagel bagel = new Bagel("Orange");
        Assertions.assertFalse(store.getBaskets().get(basketId).getItems().contains(bagel));
        String actual = store.addItemToBasket(bagel, basketId);
        Assertions.assertEquals("Bob's Bagels doesn't have Orange Bagel.", actual);
        Assertions.assertFalse(store.getBaskets().get(basketId).getItems().contains(bagel));
    }

    @Test
    public void addBagelToFullBasketTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        store.addItemToBasket(new Bagel("Onion"), basketId);
        store.addItemToBasket(new Bagel("Onion"), basketId);
        store.addItemToBasket(new Bagel("Onion"), basketId);
        String actual = store.addItemToBasket(new Bagel("Onion"), basketId);
        Assertions.assertEquals("You're basket is full!", actual);
    }

    @Test
    public void addNonExistentFillingToBagelInBasket() {
        Store store = new Store();
        int basketId = store.createBasket();
        Bagel bagel = new Bagel("Onion", new ArrayList<>(List.of(new Filling("Lettuce"))));
        String actual = store.addItemToBasket(bagel, basketId);
        Assertions.assertEquals("Bob's Bagels doesn't have Lettuce Filling.", actual);
    }

    //TODO: remove?
//    @Test
//    public void addFillingThatAllGivenBagelsAlreadyHaveTest() {
//        Store store = new Store();
//        int basketId = store.createBasket();
//        Bagel bagel = new Bagel("Onion");
//
//        store.addItemToBasket(new Bagel("Onion"), basketId);
//        store.addItemToBasket(new Bagel("Onion"), basketId);
//
//        store.addFillingToBagelInBasket("Cheese", "Onion", basketId);
//        store.addFillingToBagelInBasket("Cheese", "Onion", basketId);
//        store.addFillingToBagelInBasket("Egg", "Onion", basketId);
//
//        String actual = store.addFillingToBagelInBasket("Cheese", "Onion", basketId);
//
//        Assertions.assertEquals("All bagels of that kind in your basket already has that filling.", actual);
//    }

    @Test
    public void updateBasketCapacityToValid() {
        Store store = new Store();
        int basketId = store.createBasket();

        store.addItemToBasket(new Bagel("Onion"), basketId);
        store.addItemToBasket(new Bagel("Onion"), basketId);

        basketId = store.createBasket();

        store.addItemToBasket(new Bagel("Onion"), basketId);

        Assertions.assertTrue(store.updateBasketCapacity(2));
    }

    @Test
    public void updateBasketCapacityToInvalid() {
        Store store = new Store();
        int basketId = store.createBasket();

        store.addItemToBasket(new Bagel("Onion"), basketId);
        store.addItemToBasket(new Bagel("Onion"), basketId);
        store.addItemToBasket(new Bagel("Onion"), basketId);

        basketId = store.createBasket();

        store.addItemToBasket(new Bagel("Onion"), basketId);

        Assertions.assertFalse(store.updateBasketCapacity(2));
    }

    @Test
    public void getCostOfInvalidBagelTest() {
        Store store = new Store();
        Assertions.assertEquals(-1, store.getCostOfItem(new Bagel("Chocolate")));
    }

    @Test
    public void getCostOfValidBagelTest() {
        Store store = new Store();
        Assertions.assertEquals(0.49, store.getCostOfItem(new Bagel("Onion")));
    }

    @Test
    public void getCostOfInvalidFillingTest() {
        Store store = new Store();
        Assertions.assertEquals(-1, store.getCostOfItem(new Filling("Chocolate")));
    }

    @Test
    public void getCostOfValidFillingTest() {
        Store store = new Store();
        Assertions.assertEquals(0.12, store.getCostOfItem(new Filling("cheese")));
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
        store.addItemToBasket(new Bagel("Onion"), basketId);
        store.addItemToBasket(new Bagel("Plain"), basketId);
        Assertions.assertEquals(0.49+0.39, store.getCostOfBasket(basketId));
    }

    @Test
    public void getCostOfBasketContainingBagelsAndFillingsTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        store.addItemToBasket(new Bagel("Onion", new ArrayList<>(List.of(new Filling("egg"), new Filling("cheese")))), basketId);
        store.addItemToBasket(new Bagel("plaIN", new ArrayList<>(List.of(new Filling("cheese")))), basketId);
        Assertions.assertEquals(0.49+0.39+3*0.12, store.getCostOfBasket(basketId), 0.0001);
    }

    @Test
    public void removeNonexistentBagelFromBasketTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        store.addItemToBasket(new Bagel("Onion"), basketId);
        Assertions.assertFalse(store.removeItemFromBasket(new Bagel("plain"), basketId));
    }

    @Test
    public void removeExistentBagelNoFillingsFromBasketTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        Bagel bagel = new Bagel("Onion");
        store.addItemToBasket(bagel, basketId);
        Assertions.assertTrue(store.removeItemFromBasket(bagel, basketId));
    }

    @Test
    public void removeExistentBagelWithFillingsFromBasketTest() {
        Store store = new Store();
        store.updateBasketCapacity(4);
        int basketId = store.createBasket();

        Filling cheese = new Filling("cheese");
        Filling egg = new Filling("egg");

        Bagel onionBagelWithEggAndCheese = new Bagel("Onion", new ArrayList<>(Arrays.asList(cheese, egg)));
        Bagel onionBagelWithEgg = new Bagel("Onion", new ArrayList<>(List.of(egg)));
        Bagel plainBagel = new Bagel("plain");

        store.addItemToBasket(onionBagelWithEgg, basketId);
        store.addItemToBasket(plainBagel, basketId);
        store.addItemToBasket(plainBagel, basketId);
        store.addItemToBasket(onionBagelWithEggAndCheese, basketId);

        Assertions.assertEquals(new ArrayList<>(Arrays.asList(onionBagelWithEgg, plainBagel, plainBagel, onionBagelWithEggAndCheese)), store.getBaskets().get(basketId).getItems());

        Assertions.assertTrue(store.removeItemFromBasket(onionBagelWithEgg, basketId));
    }

    @Test
    public void getCostOfInvalidCoffeeTest() {
        Store store = new Store();
        Assertions.assertEquals(-1, store.getCostOfItem(new Coffee("Chocolate")));
    }

    @Test
    public void getCostOfValidCoffeeTest() {
        Store store = new Store();
        Assertions.assertEquals(1.29, store.getCostOfItem(new Coffee("latte")));
    }

    @Test
    public void addNonExistentCoffeeToBasketTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        Assertions.assertEquals("Bob's Bagels doesn't have Chocolate Coffee." , store.addItemToBasket(new Coffee("Chocolate"), basketId));
    }

    @Test
    public void addExistentCoffeeToBasketTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        Assertions.assertFalse(store.getBaskets().get(basketId).getItems().contains(new Coffee("latte")));
        Assertions.assertEquals("Latte Coffee added." , store.addItemToBasket(new Coffee("latte"), basketId));
        Assertions.assertTrue(store.getBaskets().get(basketId).getItems().contains(new Coffee("latte")));
    }

    @Test
    public void removeNonExistentCoffeeToBasketTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        store.addItemToBasket(new Coffee("latte"), basketId);
        Assertions.assertFalse(store.removeItemFromBasket(new Coffee("black"), basketId));
    }

    @Test
    public void removeExistentCoffeeToBasketTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        store.addItemToBasket(new Coffee("latte"), basketId);
        store.addItemToBasket(new Coffee("black"), basketId);
        store.addItemToBasket(new Coffee("white"), basketId);
        Assertions.assertTrue(store.getBaskets().get(basketId).getItems().contains(new Coffee("black")));
        Assertions.assertTrue(store.removeItemFromBasket(new Coffee("black"), basketId));
        Assertions.assertFalse(store.getBaskets().get(basketId).getItems().contains(new Coffee("black")));
    }


}
