package com.booleanuk.core.user;

import com.booleanuk.core.products.Product;

import java.math.BigDecimal;

public abstract class User {
    private String fullName;

    public User(String fullName) {
        this.fullName = fullName;
    }

    public BigDecimal checkProductPrice(Product product) {
        return product.getPrice();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
