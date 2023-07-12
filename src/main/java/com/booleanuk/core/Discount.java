package com.booleanuk.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public enum Discount {
    SixOnion(BigDecimal.valueOf(2.49)),
    TwelvePlain(BigDecimal.valueOf(3.99)),
    SixEverything(BigDecimal.valueOf(2.49)),
    BreakfastSet(BigDecimal.valueOf(1.25));

    private final BigDecimal price;
}
