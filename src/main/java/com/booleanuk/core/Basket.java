package com.booleanuk.core;

import java.util.HashMap;

public class Basket {
    private HashMap<Product, Integer> products;
    private Inventory inventory;
    private int quantity;

    public Basket(Inventory inventory, int quantity) {
        this.products = new HashMap<>();
        this.inventory = inventory;
        this.quantity = quantity;
    }


    public boolean addProduct(String sku, int quantity) {
        Product newProduct = inventory.getProduct(sku);

        if(newProduct != null){
            products.put(newProduct, quantity);
            return true;
        }

        return false;
    }
}
