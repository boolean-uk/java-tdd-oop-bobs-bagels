package com.booleanuk.core;

import com.booleanuk.core.enums.BagelType;
import com.booleanuk.core.enums.SKU;
import com.booleanuk.core.exceptions.FullBasketException;
import com.booleanuk.core.exceptions.NonExistingProductException;
import com.booleanuk.core.factory.ProductFactory;
import com.booleanuk.core.inherited.Bagel;
import com.booleanuk.core.interfaces.MenuCategory;

import java.util.ArrayList;

public class Basket {
    private final ArrayList<Product> products;
    private Integer capacity;
    private static final Integer DEFAULT_CAPACITY = 5;
    private final ProductFactory factory;

    public Basket() {
        this.products = new ArrayList<>();
        this.capacity = DEFAULT_CAPACITY;
        this.factory = new ProductFactory();
    }

    public void addProduct(MenuCategory variant) throws FullBasketException {
        if (!isFull()) {
            products.add(factory.getProduct(variant));
        } else {
            throw new FullBasketException("Your basket is full, cannot add product!");
        }
    }

    public void removeProduct(MenuCategory variant) {
        for (Product product : products) {
            if (product instanceof Bagel bagel) {
                if (bagel.getVariant() == variant) {
                    products.remove(product);
                    break;
                }
            }
        }
    }

    public void removeProduct(Product product) throws NonExistingProductException {
        boolean exists = this.getProducts().contains(product);
        if (!exists) {
            String message = "Product does not exist in the basket, cannot remove.";
            throw new NonExistingProductException(message);
        } else {
            this.products.remove(product);
        }
    }

    public void changeCapacity(int newCapacity) {
        setCapacity(newCapacity);
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
