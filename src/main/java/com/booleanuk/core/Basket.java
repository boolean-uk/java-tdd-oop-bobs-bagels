package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {

    private int capacity;
    private int productsQuantity;
    private ArrayList<Bagel> products;

    public Basket(int capacity) {
        this.capacity = capacity;
    }

    public void addProduct(Bagel bagel) {

    }

    public void removeProduct(Bagel bagel) {

    }

    public boolean isFull() {
        return true;
    }

    public void changeCapacity(int newCapacity) {

    }

    public int getTotalCost(ArrayList<Bagel> products) {
        return 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getProductsQuantity() {
        return productsQuantity;
    }

    public void setProductsQuantity(int productsQuantity) {
        this.productsQuantity = productsQuantity;
    }

    public ArrayList<Bagel> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Bagel> products) {
        this.products = products;
    }
}
