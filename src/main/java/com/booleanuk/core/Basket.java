package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private final ArrayList<Product> products;
    private Integer capacity;
    private final Integer MAX_CAPACITY = 10;

    public Basket() {
        this.products = new ArrayList<>();
        this.capacity = MAX_CAPACITY;
    }

    public void addProduct(Product product) {
        products.add(product);
    }


    public ArrayList<Product> getProducts() {
        return products;
    }
}
