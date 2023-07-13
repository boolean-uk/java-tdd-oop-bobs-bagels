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
        int cost = 0;
        HashMap<String, Integer> productsInBasket = new HashMap<>(productsCount);

        for (String productSKU : productsInBasket.keySet()) {
            cost += productsInBasket.get(productSKU) * Inventory.getProducts()
                    .get(productSKU)
                    .getPrice();
        }

        for(String productSKU : productsInBasket.keySet()){
            cost -= Inventory.getDiscount(productSKU, productsInBasket);
            if (productSKU.equals("COFB")) {
                cost -= Inventory.getCoffeeDiscount(productSKU, productsInBasket);
            }
        }
        
        return (double) cost / 100;
    }

    public double checkCostOfProduct(String productVariant){
        var products = Inventory.getProducts();

        if (!products.containsKey(productVariant))
            return 0.0d;

        return products.get(productVariant)
                .getPrice();
    }
}

