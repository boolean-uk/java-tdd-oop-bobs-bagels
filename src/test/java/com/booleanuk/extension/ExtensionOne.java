package com.booleanuk.extension;

import com.booleanuk.core.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExtensionOne {

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
}
