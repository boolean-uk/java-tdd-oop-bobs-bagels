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
}