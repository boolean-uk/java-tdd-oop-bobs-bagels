package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class BobsBagelsShopTest {
    @Test
    public void testBobsBagelsShop() {
        BobsBagelsShop shop = new BobsBagelsShop(new HashMap<>(), 3);
        Assertions.assertEquals(new HashMap<>(), shop.inventory);
        Assertions.assertEquals(3, shop.basketCapacity);
    }

    @Test
    public void testShowInventory() {
        BobsBagelsShop shop = new BobsBagelsShop(new HashMap<>(), 3);
        Assertions.assertEquals("No items in stock.", shop.showInventory());

        Item bglo = new Item("BGLO","Bagel", "Onion", 0.49);
        Item bglp = new Item("BGLP","Bagel", "Plain", 0.39);
        HashMap<Item, Integer> testInventory = new HashMap<>();
        testInventory.put(bglo, 100);
        testInventory.put(bglp, 100);
        BobsBagelsShop shop2 = new BobsBagelsShop(testInventory, 3);
        Assertions.assertEquals(
                "Bob's Bagels\n" +
                        "SKU\tPrice\tName\tVariant\n" +
                        "BGLO\t0.49\tBagel\tOnion\n" +
                        "BGLP\t0.39\tBagel\tPlain\n", shop2.showInventory());
    }
}
