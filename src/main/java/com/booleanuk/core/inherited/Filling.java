package com.booleanuk.core.inherited;

import com.booleanuk.core.Product;
import com.booleanuk.core.enums.FillingType;
import com.booleanuk.core.enums.SKU;

public class Filling extends Product {
    public Filling(String name, Double price, SKU sku, FillingType variant) {
        super(name, price, sku, variant);
    }
}
