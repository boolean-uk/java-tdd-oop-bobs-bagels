package com.booleanuk.core.product.specialoffer;

import com.booleanuk.core.product.Coffee;
import com.booleanuk.core.product.bagel.Bagel;
import com.booleanuk.core.product.bagel.Filling;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Arrays;

@Getter
public class BreakfastOffer implements SpecialOffer {
    private final Bagel bagel;
    private final Coffee coffee;

    private BreakfastOffer(Bagel bagel, Coffee coffee) {
        this.bagel = bagel;
        this.coffee = coffee;
    }

    public static BreakfastOffer of(Bagel bagel, Coffee coffee) {
        return new BreakfastOffer(bagel, coffee);
    }

    @Override
    public BigDecimal getPrice() {
        return Arrays.stream(bagel.fillings())
                .map(Filling::getPrice)
                .reduce(BigDecimal.valueOf(1.25), BigDecimal::add);
    }
}
