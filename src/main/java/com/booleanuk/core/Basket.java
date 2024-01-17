package com.booleanuk.core;

import java.util.HashMap;

public class Basket {
    HashMap<Product, Integer> products;
    User user;
    int capacity;
    int items;

    public Basket(User user){
        this.user = user;
        products = new HashMap<>();
        capacity = 10;
        items = 0;
    }

    public boolean add(String SKU){
        if (getProduct(SKU) != null) {
            Product product = getProduct(SKU);
            products.put(product, products.get(product) + 1);
        } else {
            try {
                products.put(new Product(SKU), 1);
            } catch (IllegalStateException e){
                return false;
            }
        }
        items++;
        return true;
    }

    public boolean remove(String SKU){
        return true;
    }

    public Product getProduct(String SKU){
        for (Product product : products.keySet()){
            if (SKU.equals(product.SKU)) {
                return product;
            }
        }
        return null;
    }
}
