package com.booleanuk.core.products;

import java.math.BigDecimal;

public class Coffee extends Product {

    private CoffeeVariant variant;

    public Coffee(String SKU, BigDecimal price) {
        super(SKU, price);
    }

    public Coffee(String SKU, BigDecimal price, CoffeeVariant variant) {
        super(SKU, price);
        this.variant = variant;
    }



    @Override
    public String toString() {
        return variant + " Coffee";
    }
}
