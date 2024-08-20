package com.booleanuk.core;

import java.util.HashMap;
import java.util.Objects;

public class Basket {
    HashMap<Product, Integer> currentBasket;
    Inventory inventory;
    private int basketCapacity = 10;
    private int productCount = 0;

    public Basket(){
        currentBasket = new HashMap<>();
        inventory = new Inventory();
    }

    private int getProductCount(){
        return productCount;
    }

    public int retrieveProductCount(){
        return getProductCount();
    }

    private int getBasketCapacity(){
        return basketCapacity;
    }

    public int retrieveBasketCapacity(){
        return getBasketCapacity();
    }

    public int getQuantity(String sku){
        for(Product product : currentBasket.keySet()){
            if(Objects.equals(sku, product.retrieveSku())){
                return currentBasket.get(product);
            }
        }

        return -1;
    }

    public String add(String sku) {

        for(Product product : currentBasket.keySet()){
            if(Objects.equals(sku, product.retrieveSku())){
                currentBasket.put(product, currentBasket.get(product) + 1);
                productCount++;

                return "Product added to basket";

            }
        }

        currentBasket.put(inventory.getItem(sku), 1);
        productCount++;

        return "New product added to basket";

        }

    public String add(String sku, String fillingSku) {
        String[] validFillings = {"FILB", "FILE", "FILC", "FILX", "FILS", "FILH"};

        for(Product product : currentBasket.keySet()){
            if(Objects.equals(sku, product.retrieveSku())){
                currentBasket.put(product, currentBasket.get(product) + 1);
                productCount++;

                return "Product added to basket";

            }
        }

        currentBasket.put(inventory.getItem(sku), 1);
        productCount++;

        return "New product added to basket";

    }


    public String remove(String sku){

        for(Product product : currentBasket.keySet()){
            if(Objects.equals(sku, product.retrieveSku())){
                if(currentBasket.get(product) <= 1){
                    currentBasket.remove(product);
                    productCount--;

                    return "This product is removed";
                }
                else {
                    currentBasket.put(product, currentBasket.get(product)- 1);
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

    public double costOfProduct(String sku){
        Product newItem =  inventory.getItem(sku);
        return newItem.retrievePrice();
    }

    public double totalCost(){
        double sum = 0;

        for(Product product: currentBasket.keySet()){

            double price = product.retrievePrice();
            double quantity = currentBasket.get(product);

            sum += price * quantity;
        }

        return sum;
    }
}
