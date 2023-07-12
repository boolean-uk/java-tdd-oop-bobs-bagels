package com.booleanuk.core;

import com.booleanuk.core.types.CoffeeType;

public class Coffee extends Item {
    private CoffeeType coffeeType;

    public Coffee(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
        this.price = coffeeType.getPrice();
    }



    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

}
