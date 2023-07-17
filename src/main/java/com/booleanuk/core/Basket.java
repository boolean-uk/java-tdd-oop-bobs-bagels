package com.booleanuk.core;

import com.booleanuk.core.bagel.Bagel;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Getter
public class Basket {
    private final List<Product> products = new ArrayList<>();
    private int capacity;

    public Basket(int capacity) {
        this.capacity = capacity;
    }

    public void addBagel(Bagel bagel) {
        if (isFull()) {
            throw new IllegalStateException("Cannot add new bagel - basket is full");
        }

        products.add(bagel);
    }

    public void removeBagel(Bagel bagel) {
        if (!products.contains(bagel)) {
            throw new NoSuchElementException("Cannot remove bagel because it's not in the basket");
        }

        products.remove(bagel);
    }

    public void addCoffee(Coffee coffee) {
        if (isFull()) {
            throw new IllegalStateException("Cannot add new coffee - basket is full");
        }

        products.add(coffee);
    }

    public void removeCoffee(Coffee coffee) {
        if (!products.contains(coffee)) {
            throw new NoSuchElementException("Cannot remove coffee because it's not in the basket");
        }

        products.remove(coffee);
    }

    public BigDecimal totalPrice() {
        return products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void resize(int capacity) {
        if (capacity < itemAmount()) {
            throw new IllegalArgumentException(String.format("New capacity cannot be smaller than amount of items in basket [%d]", itemAmount()));
        }

        this.capacity = capacity;
    }

    private int itemAmount() {
        return products.size();
    }

    private boolean isFull() {
        return itemAmount() == capacity;
    }
}
