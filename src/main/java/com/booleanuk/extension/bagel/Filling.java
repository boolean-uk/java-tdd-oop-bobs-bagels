package com.booleanuk.extension.bagel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public enum Filling {
    FILB("Bacon"),
    FILE("Egg"),
    FILC("Cheese"),
    FILX("Cream Cheese"),
    FILS("Smoked Salmon"),
    FILH("Ham");

    private final String variant;
    private final BigDecimal price = BigDecimal.valueOf(.12);
}
