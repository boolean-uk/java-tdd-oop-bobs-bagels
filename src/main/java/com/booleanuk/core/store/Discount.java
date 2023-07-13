package com.booleanuk.core.store;

import com.booleanuk.core.products.Product;

import java.math.BigDecimal;
import java.util.Objects;

public class Discount {
    private Product product;
    private int requiredAmount;
    private BigDecimal discountedPrice;
    private Product optionalRequiredProduct;

    public Discount(Product product, int requiredAmount, BigDecimal discountedPrice) {
        this.product = product;
        this.requiredAmount = requiredAmount;
        this.discountedPrice = discountedPrice;
    }

    public Discount(Product product, int requiredAmount, BigDecimal discountedPrice, Product optionalRequiredProduct) {
        this.product = product;
        this.requiredAmount = requiredAmount;
        this.discountedPrice = discountedPrice;
        this.optionalRequiredProduct = optionalRequiredProduct;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(int requiredAmount) {
        this.requiredAmount = requiredAmount;
    }


    public BigDecimal getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(BigDecimal discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public Product getOptionalRequiredProduct() {
        return optionalRequiredProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;
        return requiredAmount == discount.requiredAmount && Objects.equals(product, discount.product) && Objects.equals(discountedPrice, discount.discountedPrice) && Objects.equals(optionalRequiredProduct, discount.optionalRequiredProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, requiredAmount, discountedPrice, optionalRequiredProduct);
    }
}
