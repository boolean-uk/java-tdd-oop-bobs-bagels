package com.booleanuk.core;

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

    public boolean add(String productSKu, int amount){
        if (amount <= 0 || amount + currentAmountOfProducts > capacity || !Inventory.getProducts().containsKey(productSKu))
            return false;

        if (productsCount.containsKey(productSKu))
            productsCount.put(productSKu, productsCount.get(productSKu) + amount);
        else
            productsCount.put(productSKu, amount);

        currentAmountOfProducts += amount;
        return true;
    }

    public boolean remove(String productSKu, int amount){
        if (amount <= 0 || !productsCount.containsKey(productSKu) || productsCount.get(productSKu) < amount)
            return false;

        productsCount.put(productSKu, productsCount.get(productSKu) - amount);

        if (productsCount.get(productSKu) == 0)
            productsCount.remove(productSKu);

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

    public double checkCostOfProduct(String productSKu){
        var products = Inventory.getProducts();

        if (!products.containsKey(productSKu))
            return 0.0d;

        return products.get(productSKu)
                .getPrice();
    }
}
