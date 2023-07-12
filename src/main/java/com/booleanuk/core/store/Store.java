package com.booleanuk.core.store;

import com.booleanuk.core.products.Product;

import java.util.ArrayList;
import java.util.List;

public final class Store {

    private static Store INSTANCE;
    private List<Product> availableProducts;

    public static Store getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Store();
        }

        return INSTANCE;
    }


    private List<Product> loadAvailableProducts(String file) {
        return new ArrayList<Product>();
    }

}
