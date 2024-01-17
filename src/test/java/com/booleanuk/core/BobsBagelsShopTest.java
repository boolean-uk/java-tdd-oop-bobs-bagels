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
}
