package com.booleanuk.core;
import java.util.ArrayList;
import java.util.List;

// Class representing BagelOrder
class BagelOrder {
    private List<BasketItem> items;

    public BagelOrder(List<BasketItem> items) {
        this.items = items;
    }

    public int getTotalCost() {
        int totalCost = 0;

        for (BasketItem item : items) {
            totalCost += item.getCost();
        }

        return totalCost;
    }
}