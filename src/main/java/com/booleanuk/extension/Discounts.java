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

    public double calculateBulkDiscount(String sku, int num) {
        if (this.bulkDiscounts.stream().anyMatch(x->x.getSku().equals(sku))) {
            if (this.bulkDiscounts.stream().filter(x -> x.getSku().equals(sku)).findFirst().get().getNumber() <= num) {
                return (double) Math.round((((double) num * inventory.getProductCost(sku))
                        - this.bulkDiscounts.stream().filter(x -> x.getSku().equals(sku)).findFirst().get().getPrice()) * 100) /100;
            }
        }
        return 0;
    }
}