package com.booleanuk.core.Inventory;

import com.booleanuk.core.products.Product;

import java.math.BigDecimal;

public class Discount {
    private Product product;
    private int requiredAmount;
    private BigDecimal discountedPrice;

    public Discount(Product product, int requiredAmount, BigDecimal discountedPrice) {
        this.product = product;
        this.requiredAmount = requiredAmount;
        this.discountedPrice = discountedPrice;
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


}
