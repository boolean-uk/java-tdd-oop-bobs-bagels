package com.booleanuk.core;

import java.math.BigDecimal;

public abstract class Product extends Item implements Sellable{
    public Product(String sku, BigDecimal price, String name, String variant) {
        super(sku, price, name, variant);
    }
    public Product(String sku) {
        super(sku);
    }

}
