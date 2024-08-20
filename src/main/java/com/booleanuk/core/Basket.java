package com.booleanuk.core;
import com.booleanuk.core.exceptions.FullBasketException;
import com.booleanuk.core.exceptions.NonExistingProductException;
import com.booleanuk.core.factory.ProductFactory;
import com.booleanuk.core.inherited.Bagel;
import com.booleanuk.core.inherited.Coffee;
import com.booleanuk.core.inherited.Filling;
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
            this.getProducts().add(factory.getProduct(variant));
        } else {
            throw new FullBasketException("Your basket is full, cannot add product!");
        }
    }

    public void removeProduct(MenuCategory variant) throws NonExistingProductException {
        for (Product product : this.getProducts()) {
            Product specificProduct = checkAndGetProduct(product);

            if (!specificProduct.getVariant().equals(variant)) {
                String message = "Product does not exist in the basket, cannot remove.";
                throw new NonExistingProductException(message);
            }

            if (specificProduct.getVariant() == variant) {
                this.getProducts().remove(product);
                break;
            }
        }
    }

    public void changeCapacity(int newCapacity) {
        setCapacity(newCapacity);
    }

    private Boolean isFull() {
        return this.getProducts().size() == capacity;
    }

    private Product checkAndGetProduct(Product product) {
        if (product instanceof Bagel bagel) {
            return bagel;
        }
        if (product instanceof Coffee coffee) {
            return coffee;
        }
        if (product instanceof Filling filling) {
            return filling;
        }
        return null;
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
