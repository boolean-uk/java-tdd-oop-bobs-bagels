package com.booleanuk.extension;

import com.booleanuk.core.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Discounts {
    private List<Discount> discounts;
    private Inventory inventory;

    public Discounts(Inventory inventory) {
        this.inventory = inventory;
        this.discounts = new ArrayList<>();

        this.discounts.add(new BulkDiscount("BGLO", 6, 2.49));
        this.discounts.add(new BulkDiscount("BGLP", 12, 3.99));
        this.discounts.add(new BulkDiscount("BGLE", 6, 2.49));

        this.discounts.add(new ComboDiscount("COFB", "Bagel", 1.25));
        this.discounts.add(new ComboDiscount("BGLS", "Filling", 0.49));
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public double calculateDiscounts(String sku, HashMap<String, Integer> basketMap) {
        if (this.discounts.stream().anyMatch(x->x.getSku().equals(sku))) {
            Discount discount = this.discounts.stream().filter(x -> x.getSku().equals(sku)).findFirst().get();
            return discount.calculateDiscount(sku, basketMap, this.inventory);
        }
        return 0;
    }
}