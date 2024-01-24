package com.booleanuk.extension;

import com.booleanuk.core.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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

    public double calculateBulkDiscount(String sku, int num, BulkDiscount discount) {
        if (discount.getNumber() <= num) {
            return (double) Math.round((((double) discount.getNumber() * inventory.getProductCost(sku))
                    - discount.getPrice()) * 100) /100;
        }
        return 0;
    }

    public double calculateComboDiscount(String sku, Set<String> skuList, ComboDiscount discount) {
        double lowest = 0;
        double curr;
        for (String basketSku: skuList) {
            if (this.inventory.findProduct(basketSku).getName().equals(discount.getName())) {
                curr = (double) Math.round((((double) (this.inventory.findProduct(sku).getPrice() + inventory.findProduct(basketSku).getPrice()))
                        - discount.getPrice()) * 100) / 100;
                if (lowest == 0 || curr < lowest) {
                    lowest = curr;
                }
            }
        }
        return lowest;
    }

    public double calculateDiscounts(String sku, HashMap<String, Integer> basketMap) {
        if (this.discounts.stream().anyMatch(x->x.getSku().equals(sku))) {
            Discount discount = this.discounts.stream().filter(x -> x.getSku().equals(sku)).findFirst().get();
            if (discount.getClass().getSimpleName().equals("ComboDiscount")) {
                return this.calculateComboDiscount(sku, basketMap.keySet(), (ComboDiscount) discount);
            } else if (discount.getClass().getSimpleName().equals("BulkDiscount")) {
                return this.calculateBulkDiscount(sku, basketMap.get(sku), (BulkDiscount) discount);
            }
        }
        return 0;
    }
}