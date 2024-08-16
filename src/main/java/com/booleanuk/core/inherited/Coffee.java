package com.booleanuk.core.inherited;

import com.booleanuk.core.Product;
import com.booleanuk.core.enums.SKU;

public class Coffee extends Product {

    public Coffee(String name, Double price, SKU sku) {
        super(name, price, sku);
    }
}
