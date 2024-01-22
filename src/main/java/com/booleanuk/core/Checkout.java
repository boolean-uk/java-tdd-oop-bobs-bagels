package com.booleanuk.core;

public class Checkout {
    Stock stock;

    public Checkout(Stock stock) {
        this.stock = stock;
    }

    public boolean order(Basket basket) {
        return false;
    }
}
