package com.booleanuk.core.user;

import com.booleanuk.core.products.Product;

public abstract class User {
    private String fullName;

    public User(String fullName) {
        this.fullName = fullName;
    }

    public double checkProductPrice(Product product) {
        return product.getPrice();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
