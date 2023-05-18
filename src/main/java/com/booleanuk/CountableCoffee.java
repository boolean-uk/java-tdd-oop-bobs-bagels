package com.booleanuk;

public class CountableCoffee extends CountableItem {
    private final Coffee coffee;

    public CountableCoffee(Coffee coffee, int amount) {
        super(amount);
        this.coffee = coffee;
    }

    public boolean holds(Coffee coffee) {
        return this.coffee.equals(coffee);
    }

    public double getPrice() {
        return coffee.getPrice();
    }
}
