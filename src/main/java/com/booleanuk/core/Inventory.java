package com.booleanuk.core;

import java.util.HashMap;

public class Inventory {
    private static HashMap<String, Product> products;

    public static HashMap<String, Product> getProducts() {
        return products;
    }

}
