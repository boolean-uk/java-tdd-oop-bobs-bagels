package com.booleanuk.extension;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Coffee;
import com.booleanuk.core.Filling;
import com.booleanuk.core.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ExtensionOneTest {

    @Test
    public void discountMultipriceBagelTest() {
        Store store = new Store();
        store.updateBasketCapacity(16);
        int basketId = store.createBasket();

        for(int i=0; i < 16; i++) {
            store.addItemToBasket(new Bagel("plain"), basketId);
        }

        Assertions.assertEquals(16, store.getBaskets().get(basketId).getNoOfItems());
        Assertions.assertEquals(5.55, store.getCostOfBasket(basketId), 0.001);
    }

    @Test
    public void discountMultipriceBagelDifferentBagelsTest() {
        Store store = new Store();
        store.updateBasketCapacity(100);
        int basketId = store.createBasket();

        for(int i=0; i < 12; i++) {
            store.addItemToBasket(new Bagel("plain"), basketId);
        }
        for(int i=0; i < 6; i++) {
            store.addItemToBasket(new Bagel("Everything"), basketId);
        }
        for(int i=0; i < 2; i++) {
            store.addItemToBasket(new Bagel("onion"), basketId);
        }
        for(int i=0; i < 3; i++) {
            store.addItemToBasket(new Coffee("black"), basketId);
        }

        Assertions.assertEquals(20, store.getBaskets().get(basketId).getNoOfItems());
        Assertions.assertEquals(10.43, store.getCostOfBasket(basketId), 0.001);
    }

    @Test
    public void discountMultipriceBagelDifferentBagelsWithFillingsTest() {
        Store store = new Store();
        store.updateBasketCapacity(100);
        int basketId = store.createBasket();

        for(int i=0; i < 12; i++) {
            store.addItemToBasket(new Bagel("plain"), basketId);
        }
        for(int i=0; i < 6; i++) {
            store.addItemToBasket(new Bagel("everything", new ArrayList<>(Arrays.asList(new Filling("ham")))), basketId);
        }
        for(int i=0; i < 2; i++) {
            store.addItemToBasket(new Bagel("plain", new ArrayList<>(Arrays.asList(new Filling("ham"), new Filling("egg")))), basketId);

        }
        for(int i=0; i < 3; i++) {
            store.addItemToBasket(new Coffee("black"), basketId);
        }

        Assertions.assertEquals(20, store.getBaskets().get(basketId).getNoOfItems());
        Assertions.assertEquals(10.43 + 0.12*10, store.getCostOfBasket(basketId), 0.001);
    }

    @Test
    public void discountOneCoffeeAndOneBagelTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        store.addItemToBasket(new Bagel("plain"), basketId);
        store.addItemToBasket(new Coffee("black"), basketId);

        Assertions.assertEquals(1.25, store.getCostOfBasket(basketId), 0.001);
    }

    @Test
    public void discountOneCoffeeAndOneBagelWithFillingsTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        store.addItemToBasket(new Bagel("plain", new ArrayList<>(Arrays.asList(new Filling("ham"), new Filling("egg")))), basketId);
        store.addItemToBasket(new Coffee("black"), basketId);

        Assertions.assertEquals(1.25+0.12*2, store.getCostOfBasket(basketId), 0.001);
    }

}
