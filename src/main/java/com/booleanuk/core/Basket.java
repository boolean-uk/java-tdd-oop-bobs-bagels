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
        if (amount <= 0 || amount + currentAmountOfProducts > capacity || !Inventory.getProducts().containsKey(productVariant))
            return false;
        if (productsCount.containsKey(productVariant))
            productsCount.put(productVariant, productsCount.get(productVariant) + amount);
        else
            productsCount.put(productVariant, amount);
        currentAmountOfProducts += amount;
        return true;
    }

    public boolean remove(String productVariant, int amount){
        if (amount <= 0 || !productsCount.containsKey(productVariant) || productsCount.get(productVariant) < amount)
            return false;
        productsCount.put(productVariant, productsCount.get(productVariant) - amount);
        if (productsCount.get(productVariant) == 0)
            productsCount.remove(productVariant);
        currentAmountOfProducts -= amount;
        return true;
    }

    public boolean changeCapacity(int newCapacity){
        return true;
    }

    public double totalCost(){
        return 0;
    }

    public double checkCostOfProduct(String productVariant){
        var products = Inventory.getProducts();

        if (!products.containsKey(productVariant))
            return 0.0d;

        return products.get(productVariant)
                .getPrice();
    }
}
