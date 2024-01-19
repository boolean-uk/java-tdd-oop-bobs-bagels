package com.booleanuk.extension;

import com.booleanuk.core.Inventory;

import java.util.ArrayList;
import java.util.List;

public class Discounts {
    private List<BulkDiscount> bulkDiscounts;
    private Inventory inventory;

    public Discounts(Inventory inventory) {
        this.inventory = inventory;
        this.bulkDiscounts = new ArrayList<>();

        this.bulkDiscounts.add(new BulkDiscount("BGLO", 6, 2.49));
        this.bulkDiscounts.add(new BulkDiscount("BGLP", 12, 3.99));
        this.bulkDiscounts.add(new BulkDiscount("BGLE", 6, 2.49));
    }

    public List<BulkDiscount> getBulkDiscounts() {
        return bulkDiscounts;
    }
}