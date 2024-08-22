package com.booleanuk.core;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Basket {
    private final ArrayList<Product> products;
    private int basketSize;

    public Basket(int basketSize) {
        products = new ArrayList<>();
        this.basketSize = basketSize;
    }

    public int size() {
        return products.size();
    }

    public void addProduct(Product product) {
        if (products.size() < basketSize) {
            products.add(product);
        }
    }

    public void removeProduct(Product product) {
        if (!products.contains(product)) {
            throw new NoSuchElementException("No such product exists");
        }
        products.remove(product);
    }

    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void setBasketSize(int basketSize) {
        if (basketSize < products.size()) {
            products.clear();
        }
        this.basketSize = basketSize;
    }

    public float calculateCost() {
        float sum = 0.0f;
        for (Product p: products) {
            sum += p.calculateCost();
        }
        return sum;
    }
}
