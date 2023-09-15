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
        Inventory inventory = new Inventory();
        Assertions.assertFalse(inventory.inventoryList.isEmpty());
    }

    @Test
    void checkBagelsConstructorWithSkuOnly() {
        Bagel bagel = new Bagel("BGLO");
        Assertions.assertEquals(0.49d,bagel.getCost());
        Assertions.assertEquals("Onion",bagel.getVariant());
    }

    @Test
    void checkBaketTotalCost(){
        Basket basket = new Basket(3);
        basket.add(new Bagel("BGLO"));
        basket.add(new Bagel("BGLP"));
        basket.add(new Bagel("BGLE"));

        Assertions.assertEquals(3,basket.basketList.size());
        Assertions.assertEquals(1.37d,basket.getTotalCost());

    }

}
