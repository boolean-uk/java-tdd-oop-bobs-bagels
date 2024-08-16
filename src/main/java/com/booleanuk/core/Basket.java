package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Product> products;
    private Integer capacity;
    private final Integer MAX_CAPACITY = 10;

    public Basket() {
        this.products = new ArrayList<>();
        this.capacity = MAX_CAPACITY;
    }

    public Boolean addProduct(Product product) {
        return false;
    }


    public ArrayList<Product> getProducts() {
        return products;
    }
}
