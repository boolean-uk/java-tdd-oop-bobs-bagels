package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manager {
    private int basketCapacity;
    private static final List<Product> inventory = List.of(
            new Bagel("BGLO", 0.49, "Onion", Collections.emptyList()),
            new Bagel("BGLP", 0.39, "Plain", Collections.emptyList()),
            new Bagel("BGLE", 0.49, "Everything", Collections.emptyList()),
            new Bagel("BGLS", 0.49, "Sesame", Collections.emptyList()),
            new Coffee("COFB", 0.99, "Black"),
            new Coffee("COFW", 1.19, "White"),
            new Coffee("COFC", 1.29, "Cappuccino"),
            new Coffee("COFL", 1.29, "Latte"),
            new Filling("FILB", 0.12, "Bacon"),
            new Filling("FILE", 0.12, "Egg"),
            new Filling("FILC", 0.12, "Cheese"),
            new Filling("FILX", 0.12, "Cream Cheese"),
            new Filling("FILS", 0.12, "Smoked Salmon"),
            new Filling("FILH", 0.12, "Ham")
    );

    public Manager(int basketCapacity) {
        setBasketCapacity(basketCapacity);
    }

    public int getBasketCapacity() {
        return basketCapacity;
    }

    public static List<Product> getInventory(){
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
