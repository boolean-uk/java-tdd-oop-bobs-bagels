package com.booleanuk.core.basket;

import com.booleanuk.core.products.Product;

public interface BasketOperations {
    boolean addProduct(Product product);

    boolean removeProduct(Product product);

    boolean isFull();

    boolean isProductInBasket(Product product);

    BasketSummary summarizeBasket();

    int getProductsAmount();
}
