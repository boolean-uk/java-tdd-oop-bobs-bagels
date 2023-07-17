package com.booleanuk.extension.product;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;

@Getter
public class BagelSandwich implements Product {
    private final Product.Type productType;
    private final Bagel bagel;
    private final Filling[] fillings;

    public BagelSandwich(Bagel bagel, Filling... fillings) {
        this.productType = Product.Type.BagelSandwich;
        this.bagel = bagel;
        this.fillings = fillings;
    }

    @Override
    public BigDecimal getPrice() {
        var price = bagel.getPrice();
        return Arrays.stream(fillings)
                .map(Filling::getPrice)
                .reduce(price, BigDecimal::add);
    }

    @RequiredArgsConstructor
    @Getter
    public enum Bagel implements Product {
        BGLO("Onion", BigDecimal.valueOf(.49)),
        BGLP("Plain", BigDecimal.valueOf(.39)),
        BGLE("Everything", BigDecimal.valueOf(.49)),
        BGLS("Sesame", BigDecimal.valueOf(.49));

        private final Product.Type productType = Product.Type.Bagel;
        private final String variant;
        private final BigDecimal price;
    }

    @RequiredArgsConstructor
    @Getter
    public enum Filling implements Product {
        FILB("Bacon"),
        FILE("Egg"),
        FILC("Cheese"),
        FILX("Cream Cheese"),
        FILS("Smoked Salmon"),
        FILH("Ham");

        private final Product.Type productType = Type.Filling;
        private final String variant;
        private final BigDecimal price = BigDecimal.valueOf(.12);
    }
}
