package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private ArrayList<Product> stock;

    public Inventory() {
        this.stock = new ArrayList<>();
    }

    public ArrayList<Product> getStock() {
        return this.stock;
    }

    public void addStock(Product product) {
        this.stock.add(product);
    }

}
