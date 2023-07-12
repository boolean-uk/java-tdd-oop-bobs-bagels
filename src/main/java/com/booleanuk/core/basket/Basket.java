package com.booleanuk.core.basket;

import com.booleanuk.core.products.Product;

import java.util.List;

public class Basket implements BasketOperations {
    private List<Product> product;
    private int capacity;


    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public boolean removeProduct(Product product) {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isProductInBasket(Product product) {
        return false;
    }

    @Override
    public double summarizeBasket() {
        return 0;
    }

    @Override
    public boolean isProductAvailable(Product product) {
        return false;
    }

    @Override
    public int getProductsAmount() {
        return 0;
    }
}
