package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Basket {
    private static final int DEFAULT_CAPACITY = 3;
    private static int capacity = DEFAULT_CAPACITY;
    private int basketCapacity;

    private ArrayList<Product> products = new ArrayList<>();

    public Basket() {
        this.basketCapacity = capacity;
    }

    public void addProduct(Product product){
        // TODO
    }

    public void removeProduct(Product product){
        // TODO
    }

    public void changeBasketSize(int newSize){
        // TODO
    }

    public ArrayList<Product> getBagelsInBasket() {
        return products;
    }

    public BigDecimal getBasketPrice(){
        // TODO
        return null;
    }

    public void changeBasketCapacity(int newCapacity){
        // TODO
    }

    public int getCapacity(){
        return capacity;
    }

    public int getUserCapacity(){
        return basketCapacity;
    }
}
