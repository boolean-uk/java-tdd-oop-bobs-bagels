package com.booleanuk.extension.product.specialoffer;

import com.booleanuk.extension.product.BagelSandwich;
import com.booleanuk.extension.product.Coffee;
import com.booleanuk.extension.product.Product;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Arrays;

@Getter
public class BreakfastOffer implements SpecialOffer {
    private final Product.Type productType;
    private final SpecialOffer.Type offerType;
    private final BagelSandwich bagel;
    private final Coffee coffee;

    private BreakfastOffer(BagelSandwich bagel, Coffee coffee) {
        this.productType = Product.Type.SpecialOffer;
        this.offerType = SpecialOffer.Type.BreakfastOffer;
        this.bagel = bagel;
        this.coffee = coffee;
    }

    public static BreakfastOffer of(BagelSandwich bagel, Coffee coffee) {
        return new BreakfastOffer(bagel, coffee);
    }

    @Override
    public BigDecimal getPrice() {
        return Arrays.stream(bagel.getFillings())
                .map(BagelSandwich.Filling::getPrice)
                .reduce(BigDecimal.valueOf(1.25), BigDecimal::add);
    }
}
