package com.booleanuk.extension;

import com.booleanuk.core.Inventory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountsTest {

    @Test
    public void testDiscountsConstructorAddsPresetDiscounts() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Assertions.assertFalse(discounts.getBulkDiscounts().isEmpty());
    }

    @Test
    public void testCalculateBulkDiscountWithDiscount() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Assertions.assertEquals(0.69, discounts.calculateBulkDiscount("BGLP", 12));
    }

    @Test
    public void testCalculateBulkDiscountWithoutDiscount() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Assertions.assertEquals(0.0, discounts.calculateBulkDiscount("BGLP", 11));
    }
}