package com.booleanuk.extension;

import java.util.HashMap;

public class Basket {

    private final HashMap<String, Integer> productsCount;
    private int capacity;
    private int currentAmountOfProducts;

    public Basket(int capacity) {
        productsCount = new HashMap<>();
        this.capacity = capacity;
        currentAmountOfProducts = 0;
    }

    public boolean add(String productSKU, int amount){
        if (amount <= 0 || amount + currentAmountOfProducts > capacity || Inventory.productNotInInventory(productSKU))
            return false;
        if (productsCount.containsKey(productSKU))
            productsCount.put(productSKU, productsCount.get(productSKU) + amount);
        else
            productsCount.put(productSKU, amount);
        currentAmountOfProducts += amount;
        return true;
    }

    public boolean remove(String productSKU, int amount){
        if (amount <= 0 || !productsCount.containsKey(productSKU) || productsCount.get(productSKU) < amount)
            return false;
        productsCount.put(productSKU, productsCount.get(productSKU) - amount);
        if (productsCount.get(productSKU) == 0)
            productsCount.remove(productSKU);
        currentAmountOfProducts -= amount;
        return true;
    }

    public boolean changeCapacity(int newCapacity){
        if (newCapacity < currentAmountOfProducts || newCapacity == 0)
            return false;
        capacity = newCapacity;
        return true;
    }

    public HashMap<String, Integer> getProductsCount() {
        return productsCount;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentAmountOfProducts() {
        return currentAmountOfProducts;
    }

    public void clearBasket() {
        productsCount.clear();
        currentAmountOfProducts = 0;
    }
}

