package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class BobsBagelsShopTest {
    @Test
    public void testBobsBagelsShop() {
        BobsBagelsShop shop = new BobsBagelsShop(new HashMap<>());
        Assertions.assertEquals(new HashMap<>(), shop.getInventory());
    }

    @Test
    public void testShowInventory() {
        BobsBagelsShop shop = new BobsBagelsShop(new HashMap<>());
        Assertions.assertEquals("No items in stock.", shop.showInventory());

        Item bglo = new Bagel("BGLO","Bagel", "Onion", 0.49);
        Item bglp = new Bagel("BGLP","Bagel", "Plain", 0.39);
        HashMap<Item, Integer> testInventory = new HashMap<>();
        testInventory.put(bglo, 100);
        testInventory.put(bglp, 100);
        BobsBagelsShop shop2 = new BobsBagelsShop(testInventory);
        Assertions.assertEquals(
                """
                        Bob's Bagels
                        SKU\t\tPrice\tName\tVariant
                        --------------------------------------
                        BGLO\t0.49\tBagel\tOnion
                        BGLP\t0.39\tBagel\tPlain
                        """, shop2.showInventory());
    }
}
