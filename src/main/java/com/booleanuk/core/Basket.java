package com.booleanuk.core;

import com.booleanuk.core.enums.BagelType;
import com.booleanuk.core.enums.CoffeeType;
import com.booleanuk.core.inherited.Bagel;
import com.booleanuk.core.inherited.Coffee;

import java.util.ArrayList;
import java.util.Objects;

public class Basket {
    private final ArrayList<Product> products;
    private Integer capacity;
    private static final Integer MAX_CAPACITY = 10;

    public Basket() {
        this.products = new ArrayList<>();
        this.capacity = MAX_CAPACITY;
    }

    public void addProduct(Product product) {
        products.add(product);
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

    public ArrayList<Product> getProducts() {
        return products;
    }
}
