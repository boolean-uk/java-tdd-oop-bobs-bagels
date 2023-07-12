package com.booleanuk.core;

import java.util.HashMap;

public class Basket {
    private HashMap<Product, Integer> products;
    private Inventory inventory;
    private int basketCapacity;
    private int basketQuantity;

    public Basket(Inventory inventory, int quantity) {
        this.products = new HashMap<>();
        this.inventory = inventory;
        this.basketCapacity = quantity;
    }


    public boolean addProduct(String sku, int quantity) {
        if(quantity <= 0)
            return false;
        Product newProduct = inventory.getProduct(sku);

        if(newProduct == null)
            return false;

        if(basketCapacity - basketQuantity < quantity)
            return false;

        products.put(newProduct, quantity);
        basketQuantity += quantity;
        return true;
    }
}
