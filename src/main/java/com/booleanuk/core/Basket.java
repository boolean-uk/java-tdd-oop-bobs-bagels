package com.booleanuk.core;

import com.booleanuk.core.enums.BagelType;
import com.booleanuk.core.exceptions.FullBasketException;
import com.booleanuk.core.inherited.Bagel;
import java.util.ArrayList;

public class Basket {
    private final ArrayList<Product> products;
    private Integer capacity;
    private static final Integer MAX_CAPACITY = 5;

    public Basket() {
        this.products = new ArrayList<>();
        this.capacity = MAX_CAPACITY;
    }

    public void addProduct(Product product) {
        if (!isFull()) {
            products.add(product);
        } else {
            throw new FullBasketException("You have reached max basket capacity!");
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

    private Boolean isFull() {
        return this.products.size() == capacity;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
