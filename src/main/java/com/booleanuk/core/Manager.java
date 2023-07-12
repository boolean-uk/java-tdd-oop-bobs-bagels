package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private int basketCapacity;
    private List<Product> inventory;

    public Manager(int basketCapacity, List<Product> inventory) {
        setBasketCapacity(basketCapacity);
        this.inventory = inventory;
    }

    public int getBasketCapacity() {
        return basketCapacity;
    }

    public List<Product> getInventory(){
        return new ArrayList<>(inventory);
    }

    public void changeBasketsCapacity(int newCapacity){
        if(newCapacity < basketCapacity){
            throw new IllegalArgumentException("New capacity can't be less than current capacity!");
        }
        this.basketCapacity = newCapacity;
    }

    public void setBasketCapacity(int basketCapacity) {
        this.basketCapacity = basketCapacity;
        Basket.setCapacity(basketCapacity);
    }
}
