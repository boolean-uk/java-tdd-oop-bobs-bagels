package com.booleanuk.core;

import com.booleanuk.core.product.Coffee;
import com.booleanuk.core.product.Product;
import com.booleanuk.core.product.bagel.Bagel;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
        // TODO
    }

    public void removeBagel(Bagel bagel) {
        // TODO
    }

    public void addCoffee(Coffee coffee) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        // TODO
    }

    public void removeCoffee(Coffee coffee) {
        // TODO
    }

    public BigDecimal totalPrice() {
        // TODO
        return null;
    }

    public void resize(int capacity) {
        if (capacity < itemAmount()) {
            throw new IllegalArgumentException(String.format("New capacity cannot be smaller than amount of items in basket [%d]", itemAmount()));
        }

        this.capacity = capacity;
    }

    private int itemAmount() {
        // TODO
        return -1;
    }

    private boolean isFull() {
        return itemAmount() == capacity;
    }
}
