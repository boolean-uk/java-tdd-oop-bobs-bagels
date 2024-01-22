package com.booleanuk.extension;

import com.booleanuk.core.Inventory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DiscountsTest {

    @Test
    public void testDiscountsConstructorAddsPresetDiscounts() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Assertions.assertFalse(discounts.getDiscounts().isEmpty());
    }

    @Test
    public void testCalculateBulkDiscountWithDiscount() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        HashMap<String, Integer> basketMap = new HashMap<>();
        basketMap.put("BGLP", 12);
        Assertions.assertEquals(0.69, discounts.calculateDiscount("BGLP", basketMap));
    }

    @Test
    public void testCalculateBulkDiscountWithoutDiscount() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        HashMap<String, Integer> basketMap = new HashMap<>();
        basketMap.put("BGLP", 11);
        Assertions.assertEquals(0.0, discounts.calculateDiscount("BGLP", basketMap));
    }
}