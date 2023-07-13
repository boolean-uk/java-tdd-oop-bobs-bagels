package com.booleanuk.extension;

import java.math.BigDecimal;

public class Filling extends Product {

    public Filling(String sku, BigDecimal price, String variant) {
        super(sku, "Filling", price, variant);
    }
}
