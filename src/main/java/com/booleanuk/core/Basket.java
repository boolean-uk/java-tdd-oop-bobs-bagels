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
        if (getProduct(SKU) != null){
            Product product = getProduct(SKU);

            if (products.get(product) > 1){
                products.put(product, products.get(product) - 1);
            } else {
                products.remove(product);
            }
            items--;
            return true;
        } else {
            System.out.println("This product is not in your cart.");
            return false;
        }
    }

    public void updateCapacity(int newCapacity){

    }

    public void displayMenu(){

    }

    public double totalCost(){
        return 0.0;
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
