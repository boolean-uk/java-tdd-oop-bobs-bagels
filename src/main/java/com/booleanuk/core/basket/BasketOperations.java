package com.booleanuk.core.basket;

import com.booleanuk.core.products.Product;

import java.math.BigDecimal;

public interface BasketOperations {
    boolean addProduct(Product product);

    boolean removeProduct(Product product);

    boolean isFull();

    boolean isProductInBasket(Product product);

    BigDecimal summarizeBasket();

    int getProductsAmount();
}
