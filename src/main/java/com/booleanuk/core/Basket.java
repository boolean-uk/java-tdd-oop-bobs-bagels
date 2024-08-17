package com.booleanuk.core;

import java.util.HashMap;
import java.util.Objects;

public class Basket {
    HashMap<Product, Integer> currentBasket;

    private int basketCapacity = 10;
    private int productCount = 0;

    public Basket(){
        currentBasket = new HashMap<>();
    }

    public String add(Product chosenProduct) {
        String chosenName = chosenProduct.getName();

        //Check if basketCapacity is full

        if (productCount < basketCapacity){
            for (Product product : currentBasket.keySet()) {
                String name = product.getName();

                if (Objects.equals(name, chosenName)) {
                    int currentQuantity = currentBasket.get(product);

                    currentBasket.put(product, currentQuantity + 1);
                    productCount++;

                    return "Existing product added to basket";
                }
            }
            currentBasket.put(chosenProduct, 1);
            productCount++;

            return "New product added to basket";
        }
        return "Basket it full";
    }

    public int getProductCount(){
        return productCount;
    }

    public int getBasketCapacity(){
        return basketCapacity;
    }
}
