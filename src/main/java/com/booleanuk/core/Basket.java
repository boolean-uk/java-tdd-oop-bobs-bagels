package com.booleanuk.core;

import com.booleanuk.core.enums.BagelType;
import com.booleanuk.core.exceptions.FullBasketException;
import com.booleanuk.core.inherited.Bagel;

import java.util.ArrayList;

public class Basket {
    private final ArrayList<Product> products;
    private Integer capacity;
    private static final Integer DEFAULT_CAPACITY = 5;

    public Basket() {
        this.products = new ArrayList<>();
        this.capacity = DEFAULT_CAPACITY;
    }

    public void addProduct(Product product) throws FullBasketException {
        if (!isFull()) {
            products.add(product);
        } else {
            throw new FullBasketException("Your basket is full, cannot add product!");
        }
    }

    public void removeProduct(BagelType variant) {
        for (Product product : products) {
            if (product instanceof Bagel bagel) {
                if (bagel.getVariant() == variant) {
                    products.remove(product);
                    break;
                }
            }
        }
    }

    public void changeCapacity(int newCapacity) {

    }

    private Boolean isFull() {
        return this.products.size() == capacity;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    private void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getCapacity() {
        return capacity;
    }
}
