package com.booleanuk.core;

import java.util.HashMap;
import java.util.UUID;

public class Order {

    private HashMap<String, Integer> basket = new HashMap<>();
    private UUID id;

    public Order(){
        this.id = UUID.randomUUID();
    }

    public int size(){
        int result = 0;
        for(Integer i : basket.values()){
            result += i;
        }
        return result;
    }

    public boolean contains(String product){
        return basket.containsKey(product);
    }

    public int get(String product){
        return basket.get(product);
    }

    public void addProduct(String newProduct, Store store) throws Exception{
        if(!store.contains(newProduct)){
            throw new Exception("No such product in inventory!");
        }
        if(this.size() == 5){
            System.out.println("Basket is full!");
            return;
        }
        int value;
        if(basket.containsKey(newProduct)){
            value = basket.get(newProduct) + 1;
        }
        else{
            value = 1;
        }
        basket.put(newProduct, value);
    }

    public boolean removeProduct(String productToRemove){
        if(!basket.containsKey(productToRemove)){
            System.out.println("No such product in basket!");
            return false;
        }
        basket.put(productToRemove, basket.get(productToRemove) - 1);
        if(basket.get(productToRemove) == 0){
            basket.remove(productToRemove);
        }
        return true;
    }

    public UUID getId(){
        return this.id;
    }

    public void setId(UUID newId){
        this.id = newId;
    }

    public int getPrice(Store store){
        int result = 0;
        for(HashMap.Entry<String, Integer> entry : basket.entrySet()){

        }
        return result;
    }
}
