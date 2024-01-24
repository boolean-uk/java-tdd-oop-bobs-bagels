package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

// Class representing a Bagel
// Class representing a Bagel
class Bagel implements BasketItem, StockItem {
    private String type;
    private List<Fillings> fillings;

    public Bagel(String type, List<Fillings> fillings) {
        this.type = type;
        this.fillings = fillings;
    }

    public int getCost() {
        int totalCost = 0; // Base cost of the bagel

        for (Fillings filling : fillings) {
            totalCost += filling.getCost();
        }

        return totalCost;
    }

    public boolean isInStock() {
        // Logic to check if the bagel is in stock
        return true; // Placeholder logic
    }
}
