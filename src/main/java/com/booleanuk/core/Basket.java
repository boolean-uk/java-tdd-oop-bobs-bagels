package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {
    private ArrayList<Product> basketItems;
    private int basketLimit;

    public Basket() {
        this.basketItems = new ArrayList<>();
        this.basketLimit = 14; // Probably should be some way to set default limit
    }

    public Basket(int basketLimit) {
        this.basketItems = new ArrayList<>();
        this.basketLimit = basketLimit;
    }

    public ArrayList<Product> getBasketItems() {
        return this.basketItems;
    }

    public void addProduct(Product product) {
        basketItems.add(product);
    }


}
