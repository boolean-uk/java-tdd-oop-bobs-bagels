package com.booleanuk.extension;

import com.booleanuk.core.Inventory;

import java.util.HashMap;

public class ExtensionBasket {
    private final HashMap<String, Integer> productsCount;
    private int capacity;
    private int currentAmountOfProducts;

    public ExtensionBasket(int capacity) {
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
        if (newCapacity < currentAmountOfProducts || newCapacity == 0)
            return false;
        capacity = newCapacity;
        return true;
    }

    public double totalCost(){
        double cost = 0;
        for (String bagelType : productsCount.keySet()) {
            cost += productsCount.get(bagelType) * Inventory.getProducts()
                    .get(bagelType)
                    .getPrice();
        }
        return cost;
    }

    public double checkCostOfProduct(String productVariant){
        var products = Inventory.getProducts();

        if (!products.containsKey(productVariant))
            return 0.0d;

        return products.get(productVariant)
                .getPrice();
    }
}

