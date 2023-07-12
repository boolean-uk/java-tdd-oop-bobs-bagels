package com.booleanuk.core;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Getter
public class Basket {
    private final Map<Bagel, Integer> bagels = new HashMap<>();
    private final Map<Coffee, Integer> coffees = new HashMap<>();
    private int capacity;

    public Basket(int capacity) {
        this.capacity = capacity;
    }

    public void addBagel(Bagel bagel) {
        if (isFull()) {
            throw new IllegalStateException("Cannot add new bagel - basket is full");
        }
        bagels.merge(bagel, 1, Integer::sum);
    }

    public void removeBagel(Bagel bagel) {
        if (!bagels.containsKey(bagel)) {
            throw new NoSuchElementException(String.format("Cannot remove %s - it's not in the basket", bagel));
        }

        if (bagels.get(bagel) > 1) {
            bagels.put(bagel, bagels.get(bagel) - 1);
        } else {
            bagels.remove(bagel);
        }
    }

    public void addCoffee(Coffee coffee) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        coffees.merge(coffee, 1, Integer::sum);
    }

    public void removeCoffee(Coffee coffee) {
        if (!coffees.containsKey(coffee)) {
            throw new NoSuchElementException(String.format("Cannot remove %s - it's not in the basket", coffee));
        }

        if (coffees.get(coffee) > 1) {
            coffees.put(coffee, bagels.get(coffee) - 1);
        } else {
            coffees.remove(coffee);
        }
    }

    public BigDecimal totalPrice() {
        var totalPrice = bagels.entrySet().stream()
                .map(e -> {
                    var price = e.getKey().price();
                    var amount = e.getValue();

                    return price.multiply(BigDecimal.valueOf(amount));
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return coffees.entrySet().stream()
                .map(e -> {
                    var price = e.getKey().getPrice();
                    var amount = e.getValue();

                    return price.multiply(BigDecimal.valueOf(amount));
                })
                .reduce(totalPrice, BigDecimal::add);
    }

    public void resize(int capacity) {
        if (capacity < itemAmount()) {
            throw new IllegalArgumentException(String.format("New capacity cannot be smaller than amount of items in basket [%d]", itemAmount()));
        }

        this.capacity = capacity;
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

    private List<Discount> getDiscounts() {
        // TODO
        return null;
    }
}
