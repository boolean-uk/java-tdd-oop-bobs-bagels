package com.booleanuk.core.basket;

import com.booleanuk.core.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Basket implements BasketOperations {
    private List<Product> products = new ArrayList<>(0);
    private int capacity = 5;

    public Basket() {
    }

    public Basket(int capacity) {
        setCapacity(capacity);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity <= 1) {
            throw new IllegalArgumentException("Capacity cant be smaller than 1");
        }
        this.capacity = capacity;
    }

    @Override
    public boolean addProduct(Product product) {
        if (isFull()) {
            return false;
        }
        products.add(product);
        return true;
    }

    @Override
    public boolean removeProduct(Product product) {
        if (!products.contains(product)) {
            return false;
        }
        products.remove(product);
        return true;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isProductInBasket(Product product) {
        return products.contains(product);

    }

    @Override
    public double summarizeBasket() {
        return products.stream().mapToDouble(Product::getPrice).sum();

    }

    @Override
    public boolean isProductAvailable(Product product) {
        return false;
    }

    @Override
    public int getProductsAmount() {
        return this.products.size();

    }
}
