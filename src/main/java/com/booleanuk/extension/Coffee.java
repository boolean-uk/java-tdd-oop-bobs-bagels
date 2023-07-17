package com.booleanuk.extension;

import com.booleanuk.extension.types.CoffeeType;

import java.util.Objects;

public class Coffee extends Item {
    private CoffeeType coffeeType;

    public Coffee(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
        this.price = coffeeType.getPrice();
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coffee coffee)) return false;
        return coffeeType == coffee.coffeeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffeeType);
    }
    
    @Override
    public String toString() {
        return coffeeType + "";
    }
}
