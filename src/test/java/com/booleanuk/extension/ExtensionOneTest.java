package com.booleanuk.extension;

import com.booleanuk.core.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExtensionOneTest {

    @Test
    public void discountMultipriceBagelTest() {
        Store store = new Store();
        store.updateBasketCapacity(16);
        int basketId = store.createBasket();

        for(int i=0; i < 16; i++) {
            store.addBagelToBasket("plain", basketId);
        }

        Assertions.assertEquals(16, store.getBaskets().get(basketId).getNoOfBagels());
        Assertions.assertEquals(5.55, store.getCostOfBasket(basketId), 0.001);
    }

    @Test
    public void discountMultipriceBagelDifferentBagelsTest() {
        Store store = new Store();
        store.updateBasketCapacity(100);
        int basketId = store.createBasket();

        for(int i=0; i < 12; i++) {
            store.addBagelToBasket("plain", basketId);
        }
        for(int i=0; i < 6; i++) {
            store.addBagelToBasket("Everything", basketId);
        }
        for(int i=0; i < 2; i++) {
            store.addBagelToBasket("oNIoN", basketId);
        }
        for(int i=0; i < 3; i++) {
            store.addCoffeeToBasket("blaCk", basketId);
        }

        Assertions.assertEquals(20, store.getBaskets().get(basketId).getNoOfBagels());
        Assertions.assertEquals(10.43, store.getCostOfBasket(basketId), 0.001);
    }

    @Test
    public void discountMultipriceBagelDifferentBagelsWithFillingsTest() {
        Store store = new Store();
        store.updateBasketCapacity(100);
        int basketId = store.createBasket();

        for(int i=0; i < 12; i++) {
            store.addBagelToBasket("plain", basketId);
        }
        for(int i=0; i < 6; i++) {
            store.addBagelToBasket("Everything", basketId);
            store.addFillingToBagelInBasket("cheese", "everything", basketId);
        }
        for(int i=0; i < 2; i++) {
            store.addBagelToBasket("oNIoN", basketId);
            store.addFillingToBagelInBasket("hAM", "everything", basketId);
            store.addFillingToBagelInBasket("egG", "everything", basketId);

        }
        for(int i=0; i < 3; i++) {
            store.addCoffeeToBasket("blaCk", basketId);
        }

        Assertions.assertEquals(20, store.getBaskets().get(basketId).getNoOfBagels());
        Assertions.assertEquals(10.43 + 0.12*10, store.getCostOfBasket(basketId), 0.001);
    }

    @Test
    public void discountOneCoffeeAndOneBagelTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        store.addBagelToBasket("plain", basketId);
        store.addCoffeeToBasket("black", basketId);

        Assertions.assertEquals(1.25, store.getCostOfBasket(basketId), 0.001);
    }

    @Test
    public void discountOneCoffeeAndOneBagelWithFillingsTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        store.addBagelToBasket("plain", basketId);
        store.addCoffeeToBasket("black", basketId);
        store.addFillingToBagelInBasket("hAM", "plain", basketId);
        store.addFillingToBagelInBasket("egG", "plain", basketId);

        Assertions.assertEquals(1.25+0.12*2, store.getCostOfBasket(basketId), 0.001);
    }

}
