package com.booleanuk.core;

import java.util.HashMap;

public class Basket {
    private HashMap<String, Integer> productsCount;
    private int capacity;
    private int currentAmountOfProducts;

    public Basket(int capacity) {
        productsCount = new HashMap<String, Integer>();
        this.capacity = capacity;
        currentAmountOfProducts = 0;
    }

    public boolean add(String productVariant, int amount){
        return true;
    }

    public boolean remove(String productVariant, int amount){
        return true;
    }

    public boolean changeCapacity(int newCapacity){
        return true;
    }

    public double totalCost(){
        return 0;
    }

    public double checkCostOfProduct(String productVariant){
        return 0;
    }
}
