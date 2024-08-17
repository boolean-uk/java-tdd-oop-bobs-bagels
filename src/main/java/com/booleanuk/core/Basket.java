package com.booleanuk.core;

import java.util.HashMap;
import java.util.Objects;

public class Basket {
    HashMap<Product, Integer> currentBasket;
    private int basketCapacity = 10;

    public Basket(){
        currentBasket = new HashMap<>();
    }

    public String addToCurrentBasket(Product chosenProduct) {
        String chosenName = chosenProduct.getName();

        for (Product product : currentBasket.keySet()) {
            String name = product.getName();

            if (Objects.equals(name, chosenName)) {
                int currentQuantity = currentBasket.get(product);

                currentBasket.put(product, currentQuantity + 1);

                return "Existing product added to basket";
            }
        }

        currentBasket.put(chosenProduct, 1);

        return "New product added to basket";
    }
}
