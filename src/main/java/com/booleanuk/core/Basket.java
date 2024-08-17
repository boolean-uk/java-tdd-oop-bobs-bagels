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

    public int getProductCount(){
        return productCount;
    }

    public int getBasketCapacity(){
        return basketCapacity;
    }

    public String add(Product chosenProduct) {

        //Should change to sku
        String chosenName = chosenProduct.getName();

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

    public String remove(Product chosenProduct){

        String chosenSku = chosenProduct.getSku();

        for(Product product : currentBasket.keySet()){
            String sku = product.getSku();

            if(Objects.equals(sku, chosenSku)){
                if(currentBasket.get(product) <= 1){
                    currentBasket.remove(product);
                    productCount--;

                    return "This product is removed";
                }
                else {
                    int currentQuantity = currentBasket.get(product);

                    currentBasket.put(product, currentQuantity - 1);
                    productCount--;

                    return "One product is removed";
                }
            }
        }
        return "This product does not exist in basket!";

    }

    public void changeCapacity(int newSize){
        basketCapacity = newSize;
    }



}
