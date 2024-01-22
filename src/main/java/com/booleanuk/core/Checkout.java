package com.booleanuk.core;

public class Checkout {
    Stock stock;

    public Checkout(Stock stock) {
        this.stock = stock;
    }

    public double sumPrice(Basket basket) {
        double totalCost = 0;
        for(Product product : basket.getInventory()) {
            totalCost += product.getPrice();
        }
        return totalCost;
    }
    public boolean order(Basket basket) {
        return false;
    }
}
