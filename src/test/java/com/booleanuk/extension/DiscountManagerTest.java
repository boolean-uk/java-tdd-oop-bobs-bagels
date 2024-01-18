package com.booleanuk.extension;

import com.booleanuk.core.models.Basket;
import com.booleanuk.core.models.Item;
import com.booleanuk.core.models.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class DiscountManagerTest {
    @Test
    public void doesCalculateTheCorrectDiscount() throws FileNotFoundException, URISyntaxException {
        Store store = new Store("Bob's Bagels");
        Basket basket = new Basket(40);

        Item bagelOnion = store.getItemBySKU("BGLO");
        basket.addItem(bagelOnion);
        basket.addItem(bagelOnion);
        Item bagelPlain = store.getItemBySKU("BGLP");
        for (int i = 0; i < 12; i++) {
            basket.addItem(bagelPlain);
        }
        Item bagelEverything = store.getItemBySKU("BGLE");
        for (int i = 0; i < 6; i++) {
            basket.addItem(bagelEverything);
        }
        Item coffeeBlack = store.getItemBySKU("COFB");
        basket.addItem(coffeeBlack);
        basket.addItem(coffeeBlack);
        basket.addItem(coffeeBlack);

        Assertions.assertEquals(1.14, DiscountManager.getTotalDiscount(basket));
        Assertions.assertEquals(10.43, basket.getDiscountedTotal());
    }
}
