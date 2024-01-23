package com.booleanuk.extension;

import com.booleanuk.core.*;
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
    public void noDiscountForMultipleCoffees() {
        HashMap<Item, Integer> testInventory = new HashMap<>();
        Item cofl = new Coffee("COFL", "Latte", 1.29);
        testInventory.put(cofl, 30);
        BobsBagelsShop shop = new BobsBagelsShop(testInventory);
        Basket basket = new Basket(shop, 16);
        basket.add(cofl); basket.add(cofl); basket.add(cofl); basket.add(cofl); basket.add(cofl); basket.add(cofl);

        Assertions.assertEquals(7.74, basket.discountPerItem().get(cofl)[0]);
        Assertions.assertEquals(0.0, basket.discountPerItem().get(cofl)[1]);
    }

    @Test
    public void noDiscountForMultipleFillings() {
        HashMap<Item, Integer> testInventory = new HashMap<>();
        Item filh = new Filling("FILH", "Ham", 0.12);
        testInventory.put(filh, 30);
        BobsBagelsShop shop = new BobsBagelsShop(testInventory);
        Basket basket = new Basket(shop, 16);
        basket.add(filh); basket.add(filh); basket.add(filh); basket.add(filh); basket.add(filh); basket.add(filh);

        Assertions.assertEquals(0.72, basket.discountPerItem().get(filh)[0]);
        Assertions.assertEquals(0.0, basket.discountPerItem().get(filh)[1]);
    }

    @Test
    public void discountForBlackCoffeeAndBagel() {
        HashMap<Item, Integer> testInventory = new HashMap<>();
        Item bglo = new Bagel("BGLO", "Onion", 0.49);
        Item cofb = new Coffee("COFB", "Black", 0.99);
        testInventory.put(bglo, 30);
        testInventory.put(cofb, 30);
        BobsBagelsShop shop = new BobsBagelsShop(testInventory);
        Basket basket = new Basket(shop, 6);
        basket.add(bglo); basket.add(bglo); basket.add(bglo);
        basket.add(cofb);

        // One coffee and one bagel are discounted.
        Assertions.assertEquals(0.49+0.49+1.25*(1.0/3), basket.discountPerItem().get(bglo)[0]);
        Assertions.assertEquals(0.49-1.25*(1.0/3), basket.discountPerItem().get(bglo)[1]);
        Assertions.assertEquals(1.25*(2.0/3), basket.discountPerItem().get(cofb)[0]);
        Assertions.assertEquals(0.99-1.25*(2.0/3), basket.discountPerItem().get(cofb)[1]);

        basket.add(cofb);

        // Two coffees and two bagels are discounted.
        Assertions.assertEquals(0.49+2*(1.25*(1.0/3)), basket.discountPerItem().get(bglo)[0]);
        Assertions.assertEquals(0.49*2-2*(1.25*(1.0/3)), basket.discountPerItem().get(bglo)[1]);
        Assertions.assertEquals((1.25*(2.0/3))*2, basket.discountPerItem().get(cofb)[0]);
        Assertions.assertEquals((0.99-1.25*(2.0/3))*2, basket.discountPerItem().get(cofb)[1]);
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
