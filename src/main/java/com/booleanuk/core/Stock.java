package com.booleanuk.core;

import java.util.ArrayList;

public class Stock implements Inventory {
    private ArrayList<Product> stock;

    public Stock() {
        this.stock = new ArrayList<>();
    }

    @Override
    public ArrayList<Product> getInventory() {
        return this.stock;
    }

    @Override
    public void addProduct(Product product) {
        this.stock.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        this.stock.remove(product);
    }

    @Override
    public boolean inInventory(Product product) {
        return this.stock.contains(product);
    }


}
