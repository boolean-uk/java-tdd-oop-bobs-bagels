package com.booleanuk.core;


import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Arrays;

@Builder
@Getter
public class Bagel implements Product {
    private final BagelType type;
    private final Filling[] fillings;

    public Bagel(BagelType type, Filling... fillings) {
        this.type = type;
        this.fillings = fillings;
    }

    public BigDecimal price() {
        var price = type.getPrice();
        return Arrays.stream(fillings)
                .map(Filling::getPrice)
                .reduce(price, BigDecimal::add);
    }
}
