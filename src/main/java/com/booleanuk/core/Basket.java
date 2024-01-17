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
        if (items < capacity){
            if (getProduct(SKU) != null) {
                Product product = getProduct(SKU);
                products.put(product, products.get(product) + 1);
            } else {
                try {
                    products.put(new Product(SKU), 1);
                } catch (IllegalStateException e){
                    System.out.println("This item is not on the menu.");
                    return false;
                }
            }
            items++;
            return true;
        }
        System.out.println("Your basket is full.");
        return false;
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
        if (user instanceof Manager){
            capacity = newCapacity;

            if (newCapacity < items){
                products = new HashMap<>();
                items = 0;

                System.out.println("The capacity has been updated. " +
                        "Cart can only hold " + newCapacity + " items. " +
                        "Your basket has been reset.");
            }
        }
    }

    public void displayMenu(){

    }

    public double totalCost(){
        double totalCost = 0;
        for (Product product : products.keySet()){
            totalCost += product.price*products.get(product);
        }
        return totalCost;
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
