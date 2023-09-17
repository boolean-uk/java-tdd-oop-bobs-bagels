package com.booleanuk.core.Products;

import java.math.BigDecimal;

public class Filling extends Item {
    public Filling(String sku, BigDecimal price, String name, String variant) {
        super(sku, price, name, variant);
    }
// double filling etc.
    @Override
    public double calculateTotalPrice(int quantity) {
        return 0;
    }
}
