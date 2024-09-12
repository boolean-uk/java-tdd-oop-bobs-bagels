package com.booleanuk.core;
import java.util.ArrayList;
import java.util.List;

// Class representing BagelInventory
class BagelInventory {
    private List<Product> availableProducts;

    public BagelInventory(List<Product> availableProducts) {
        this.availableProducts = availableProducts;
    }

    public boolean isInStock(StockItem item) {
        return item.isInStock();
    }
}