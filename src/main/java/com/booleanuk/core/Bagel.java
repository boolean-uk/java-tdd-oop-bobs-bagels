package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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

        return true; // Placeholder logic
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Bagel bagel = (Bagel) obj;
        return Objects.equals(type, bagel.type) && Objects.equals(fillings, bagel.fillings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fillings);
    }
}
