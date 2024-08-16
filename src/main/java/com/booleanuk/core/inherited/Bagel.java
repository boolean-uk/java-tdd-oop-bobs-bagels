package com.booleanuk.core.inherited;

import com.booleanuk.core.Product;
import com.booleanuk.core.enums.BagelType;
import com.booleanuk.core.enums.SKU;

public class Bagel extends Product {
    private BagelType variant;

    public Bagel(String name, Double price, SKU sku, BagelType variant) {
        super(name, price, sku);
        this.variant = variant;
    }
}
