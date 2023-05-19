package com.booleanuk;

public class CountableCoffee extends CountableItem {
    public CountableCoffee(Coffee coffee, int amount) {
        super(coffee, amount);
    }

    public boolean holds(Coffee coffee) {
        Coffee c = (Coffee) super.getItem();
        return c.equals(coffee);
    }
}
