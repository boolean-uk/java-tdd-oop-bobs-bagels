package com.booleanuk.core;

// Class representing fillings that can be added to a bagel
class Fillings implements BasketItem, StockItem {
    private String type;
    private int cost;

    public Fillings(String type, int cost) {
        this.type = type;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public boolean isInStock() {
        // Logic to check if the filling is in stock
        return true; // Placeholder logic
    }
}
