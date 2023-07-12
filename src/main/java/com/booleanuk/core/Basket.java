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

        if(products.containsKey(newProduct)) {
            products.replace(newProduct, quantity + products.get(newProduct));
            return true;
        }
        products.put(newProduct, quantity);
        basketQuantity += quantity;
        return true;
    }

    public boolean removeProduct(String sku, int quantity) {
        if(quantity <= 0)
            return false;

        Product newProduct = inventory.getProduct(sku);
        if(!products.containsKey(newProduct))
            return false;
        if(products.get(newProduct) < quantity)
            return false;
        if(products.get(newProduct) == quantity) {
            products.remove(newProduct);
            basketQuantity -= quantity;
            return true;
        }

        products.replace(newProduct, products.get(newProduct) - quantity);
        basketQuantity -= quantity;
        return true;
    }
}
