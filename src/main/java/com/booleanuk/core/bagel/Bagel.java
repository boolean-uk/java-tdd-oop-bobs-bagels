package com.booleanuk.core.bagel;


import com.booleanuk.core.Product;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Arrays;

@Builder
public record Bagel(BagelType type, Filling... fillings) implements Product {
    @Override
    public BigDecimal getPrice() {
        var price = type.getPrice();
        return Arrays.stream(fillings)
                .map(Filling::getPrice)
                .reduce(price, BigDecimal::add);
    }
}
