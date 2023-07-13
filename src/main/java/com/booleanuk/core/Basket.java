package com.booleanuk.core;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Basket {

    private int capacity;
    private ArrayList<Bagel> products;

    public Basket(int capacity) {
        this.capacity = capacity;
    }

    public void addProduct(Bagel bagel) throws IllegalAccessException {
        if (isFull()) {
            throw new IllegalAccessException("Basket is already full");
        }
        products.add(bagel);
    }

    public void removeProduct(Bagel bagel) {
        if (!products.contains(bagel)) {
            throw new NoSuchElementException("You dont have this product in your basket")
        }
        products.remove(bagel);
    }

    public boolean isFull() {
        return getProductsQuantity() == capacity;
    }

    public void changeCapacity(int newCapacity) {
        if (newCapacity < getProductsQuantity()) {
            throw new IllegalArgumentException("You cannot do it");
        }
        this.capacity = newCapacity;
    }

    public Double getTotalCost(ArrayList<Bagel> products) {
        return products.stream()
                .mapToDouble(Bagel::getPrice)
                .sum();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getProductsQuantity() {
        return products.size();
    }

    public ArrayList<Bagel> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Bagel> products) {
        this.products = products;
    }
}
