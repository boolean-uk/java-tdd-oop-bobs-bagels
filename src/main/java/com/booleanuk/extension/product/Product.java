package com.booleanuk.extension.product;

import java.math.BigDecimal;

public interface Product {
    Product.Type getProductType();

    BigDecimal getPrice();

    public enum Type {
        BagelSandwich,
        Bagel,
        Filling,
        Coffee,
        SpecialOffer
    }
}
