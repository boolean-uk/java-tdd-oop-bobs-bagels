package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Predicate;

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

    public void addProduct(Product product, int number) {
        for(int i = 0; i < number; i++) {
            this.basketItems.add(product);
        }
    }

    public void addProduct(ArrayList<Product> products) {
        this.basketItems.addAll(products);

    }

    public void removeProduct(Product product) {
        this.basketItems.remove(product);
    }

    public void removeProduct(String productName) {
        for(int i = 0; i < this.basketItems.size(); i++) {
            if(basketItems.get(i).name.equals(productName)) {
                this.basketItems.remove(i);
            }
        }
    }



}
