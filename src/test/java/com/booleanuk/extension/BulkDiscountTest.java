package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BulkDiscountTest {

    @Test
    public void testBulkDiscountConstructor() {
        BulkDiscount bulkDiscount = new BulkDiscount("SKU", 5, 0.49);
        Assertions.assertEquals("SKU",bulkDiscount.getSku());
        Assertions.assertEquals(5,bulkDiscount.getNumber());
        Assertions.assertEquals(0.49,bulkDiscount.getPrice());
    }
}