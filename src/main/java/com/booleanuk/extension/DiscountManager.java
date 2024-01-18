package com.booleanuk.extension;

import com.booleanuk.core.models.Basket;

public record DiscountManager(Basket basket) {
    public double getBasketDiscount() {
        return 0.0;
    }
}
