package com.booleanuk.core;

import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final Map<Bagel, Integer> bagels = new HashMap<>();
    private final Map<Coffee, Integer> coffees = new HashMap<>();
    @Setter
    private int capacity;

    public Basket(int capacity) {
        this.capacity = capacity;
    }

    public void addBagel(Bagel bagel) {
        // TODO
    }

    public void removeBagel(Bagel bagel) {
        // TODO
    }

    public void addCoffee(Coffee coffee) {
        // TODO
    }

    public void removeCoffee(Coffee coffee) {
        // TODO
    }

    public BigDecimal totalPrice() {
        // TODO
        return null;
    }

    private int itemAmount() {
        var amount = bagels.values().stream()
                .reduce(0, Integer::sum);
        return coffees.values().stream()
                .reduce(amount, Integer::sum);
    }

    private boolean isFull() {
        return itemAmount() == capacity;
    }
}
