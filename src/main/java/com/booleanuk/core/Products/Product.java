package com.booleanuk.core.Products;

import java.math.BigDecimal;

public abstract class Product extends Item implements Sellable{
    public Product(String SKU, BigDecimal price, String name) {
        super(SKU, price, name);
    }
    public Product(String SKU) {
        super(SKU);
    }

}
