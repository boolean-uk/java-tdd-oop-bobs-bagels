package com.booleanuk.core.product.bagel;


import com.booleanuk.core.product.Product;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Arrays;

@Builder
@Getter
public record Bagel(BagelType type, Filling... fillings) implements Product {
    @Override
    public BigDecimal getPrice() {
        var price = type.getPrice();
        return Arrays.stream(fillings)
                .map(Filling::getPrice)
                .reduce(price, BigDecimal::add);
    }
}
