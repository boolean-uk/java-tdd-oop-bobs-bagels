package com.booleanuk.core;

public class Coffee extends Product{
    private CoffeeType coffeeType;

    public Coffee(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
        updatePrice();
    }

    private void updatePrice(){
        setPrice(coffeeType.getPrice());
    }
}