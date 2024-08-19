package com.booleanuk.core;

import java.util.HashMap;
import java.util.UUID;

public class Order {

    public HashMap<String, Integer> basket = new HashMap<>();
    private UUID id;
    int price;

    public Order(){
        this.id = UUID.randomUUID();
        this.price = 0;
    }

    public void addProduct(String newProduct){
        int value;
        if(basket.containsKey(newProduct)){
            value = basket.get(newProduct) + 1;
        }
        else{
            value = 1;
        }
        basket.put(newProduct, value);
    }

    public void removeProduct(String productToRemove){
        if(basket.containsKey(productToRemove)){
            basket.put(productToRemove, basket.get(productToRemove) - 1);
            if(basket.get(productToRemove) == 0){
                basket.remove(productToRemove);
            }
        }
    }

    public UUID getId(){
        return this.id;
    }

    public void setId(UUID newId){
        this.id = newId;
    }

    public int getPrice(){
        return this.price;
    }
}
