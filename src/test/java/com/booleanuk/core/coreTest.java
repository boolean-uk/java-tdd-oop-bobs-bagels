package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class coreTest {
    @Test
    void addAndRemoveBagelsFromBasket() {
        Basket basket = new Basket(2);
        Bagel bagel = new Bagel("BGLO",0.49d,"Onion");
        Assertions.assertTrue(basket.add(bagel));
        Assertions.assertTrue(basket.remove("BGLO"));
        Assertions.assertFalse(basket.remove("panagiotis"));
    }

    @Test
    void manageBasketSize() {
        Basket basket = new Basket(1);
        Bagel bagel1 = new Bagel("BGLO",0.49d,"Onion");
        Bagel bagel2 = new Bagel("BGLP",0.39d,"Plain");
        basket.add(bagel1);
        Assertions.assertFalse(basket.add(bagel2));
        basket.setCapacity(12);
        Assertions.assertEquals(12,basket.getCapacity());
    }

    @Test
    void checkInventoryInitialization(){
        Basket basket = new Basket(1);
        Assertions.assertFalse(basket.inventory.isEmpty());
    }

    @Test
    void basketCostTest() {
        Basket basket = new Basket(2);
        Bagel bagel1 = new Bagel("BGLO");
        Bagel bagel2 = new Bagel("BGLP");
        basket.add(bagel1);
        basket.add(bagel2);
        Assertions.assertEquals(0.88d,basket.getTotalCost());
        basket.remove(bagel1.getSku());
        Assertions.assertEquals(0.39d,basket.getTotalCost());
    }
}
