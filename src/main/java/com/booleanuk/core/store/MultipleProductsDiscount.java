package com.booleanuk.core.store;

import com.booleanuk.core.products.Product;

import java.math.BigDecimal;

public class MultipleProductsDiscount extends Discount {

    private Product optionalRequiredProduct;

    public MultipleProductsDiscount(Product product, int requiredAmount, BigDecimal discountedPrice, Product optionalRequiredProduct) {
        super(product, requiredAmount, discountedPrice);
        this.optionalRequiredProduct = optionalRequiredProduct;
    }

    public Product getOptionalRequiredProduct() {
        return optionalRequiredProduct;
    }

    public void setOptionalRequiredProduct(Product optionalRequiredProduct) {
        this.optionalRequiredProduct = optionalRequiredProduct;
    }
}
