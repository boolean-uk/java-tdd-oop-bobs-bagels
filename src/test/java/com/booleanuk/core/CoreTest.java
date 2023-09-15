package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoreTest {
    @Test
    void addAndRemoveBagelsFromBasket() {
        Basket basket = new Basket(2);
        Bagel bagel = new Bagel("BGLO",0.49d,"Onion");
        Assertions.assertTrue(basket.add(bagel)); //user story 1
        Assertions.assertTrue(basket.remove("BGLO")); //user story 2
        Assertions.assertFalse(basket.remove("panagiotis")); //user story 5
    }

    @Test
    void manageBasketSize() {
        Basket basket = new Basket(1);
        Bagel bagel1 = new Bagel("BGLO",0.49d,"Onion");
        Bagel bagel2 = new Bagel("BGLP",0.39d,"Plain");
        basket.add(bagel1);
        Assertions.assertFalse(basket.add(bagel2)); //user story 3
        basket.setCapacity(12); //user story 4
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
        Assertions.assertEquals(0.49d,bagel.getCost()); //user story 7
        Assertions.assertEquals("Onion",bagel.getVariant());
    }

    @Test
    void checkBaketTotalCost(){
        Basket basket = new Basket(3);
        basket.add(new Bagel("BGLO"));
        basket.add(new Bagel("BGLP"));
        basket.add(new Bagel("BGLE"));

        Assertions.assertEquals(3,basket.basketList.size());
        Assertions.assertEquals(1.37d,basket.getTotalCost()); //user story 6
    }

    @Test
    void checkFillingConstructorWithSkuOnly() {
        Filling filling = new Filling("FILE");
        Assertions.assertEquals(0.12d,filling.getCost());
        Assertions.assertEquals("Egg",filling.getVariant());
    }


}
