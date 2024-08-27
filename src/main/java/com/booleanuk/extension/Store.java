package com.booleanuk.extension;

import java.util.HashMap;

public class Store {

    private Product[] inventory = new Product[14];
    private HashMap<String, Order> orders;
    private int basketCapacity;

    public Store(int basketCapacity) {
        this.basketCapacity = basketCapacity;
    }

    public void addProduct(Product product, int index){
        inventory[index] = product;
    }

    public boolean contains(String searchedProduct){
        for(Product product : inventory){
            if(product.getSku().equals(searchedProduct)){
                return true;
            }
        }
        return false;
    }

    public int getPrice(String searchedProduct){
        for(Product product : inventory){
            if(product.getSku().equals(searchedProduct)){
                return product.getPrice();
            }
        }
        return 0;
    }

    public Product getProduct(String searchedProduct){
        for(Product product : inventory){
            if(product.getSku().equals(searchedProduct)){
                return product;
            }
        }
        return null;
    }

    public int getBasketCapacity(){
        return this.basketCapacity;
    }

    public void setBasketCapacity(int newCapacity){
        this.basketCapacity = newCapacity;
    }
}