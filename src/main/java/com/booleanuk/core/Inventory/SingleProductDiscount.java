package com.booleanuk.core.Inventory;

import com.booleanuk.core.products.Product;

import java.math.BigDecimal;

public class SingleProductDiscount extends Discount {
    public SingleProductDiscount(Product product, int requiredAmount, BigDecimal discountedPrice) {
        super(product, requiredAmount, discountedPrice);
    }
}
