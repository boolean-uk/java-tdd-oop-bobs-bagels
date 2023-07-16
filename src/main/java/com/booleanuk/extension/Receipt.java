package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Receipt {
    private final HashMap<String, Integer> costs;
    private final HashMap<String, Integer> amounts;
    private final HashMap<String, Integer> discounts;
    private final double totalCost;
    private final double totalDiscount;
    private final LocalDateTime creationDate;

    public Receipt(
            HashMap<String, Integer> costs,
            HashMap<String, Integer> amounts,
            HashMap<String, Integer> discounts,
            double totalCost,
            double totalDiscount
    ) {
        this.costs = costs;
        this.amounts = amounts;
        this.discounts = discounts;
        this.totalCost = totalCost;
        this.totalDiscount = totalDiscount;
        this.creationDate = LocalDateTime.now();
    }

    public HashMap<String, Integer> getCosts() {
        return costs;
    }

    public HashMap<String, Integer> getAmounts() {
        return amounts;
    }

    public HashMap<String, Integer> getDiscounts() {
        return discounts;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public double getDiscount(String productSKU) {
        return (double) discounts.get(productSKU) / 100;
    }

    public double getCost(String productSKU) {
        return (double) costs.get(productSKU) / 100;
    }

    public int getQuantity(String productSKU) {
        return amounts.get(productSKU);
    }
}
