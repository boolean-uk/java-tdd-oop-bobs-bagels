package com.booleanuk.core.basket;

import com.booleanuk.core.products.Product;

public interface BasketOperations {
    boolean addProduct(Product product);

    boolean removeProduct(Product product);

    boolean isFull();

    boolean isProductInBasket(Product product);

    double summarizeBasket();

    int getProductsAmount();
}
