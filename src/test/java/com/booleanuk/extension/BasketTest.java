package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Bagel;
import com.booleanuk.core.BobsBagelsShop;
import com.booleanuk.core.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class BasketTest {

    @Test
    public void discountPerItem() {
        HashMap<Item, Integer> testInventory = new HashMap<>();
        Item bglo = new Bagel("BGLO", "Onion", 0.49);
        testInventory.put(bglo, 50);
        BobsBagelsShop shop = new BobsBagelsShop(testInventory);
        Basket basket = new Basket(shop, 16);
        basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo);

        // 1 for 0.49, 6 for 2.29, 12 for 3.99
        Assertions.assertEquals(3.27, basket.discountPerItem().get(bglo)[0]);
        Assertions.assertEquals(0.65, basket.discountPerItem().get(bglo)[1]);

        basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo);

        Assertions.assertEquals(5.95, basket.discountPerItem().get(bglo)[0]);
        Assertions.assertEquals(1.89, basket.discountPerItem().get(bglo)[1]);
    }

    @Test
    public void totalCostWithDiscount() {
        HashMap<Item, Integer> testInventory = new HashMap<>();
        Item bglo = new Bagel("BGLO", "Onion", 0.49);
        testInventory.put(bglo, 50);
        BobsBagelsShop shop = new BobsBagelsShop(testInventory);
        Basket basket = new Basket(shop, 16);
        basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo);
        basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo);

        HashMap<Item, double[]> mapPriceAndSavings = basket.discountPerItem();
        // Originally 16 Onion bagels = 7.84, new price 5.95, savings = 1.89
        Assertions.assertEquals(5.95, basket.totalCostWithDiscount(mapPriceAndSavings));


        Basket basket2 = new Basket(shop, 3);
        HashMap<Item, double[]> mapPriceAndSavings2 = basket2.discountPerItem();
        Assertions.assertEquals(0.0, basket2.totalCostWithDiscount(mapPriceAndSavings2));
    }
}
