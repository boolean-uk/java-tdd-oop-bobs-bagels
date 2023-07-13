package com.booleanuk.core.bagel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public enum BagelType {
    BGLO("Onion", BigDecimal.valueOf(.49)),
    BGLP("Plain", BigDecimal.valueOf(.39)),
    BGLE("Everything", BigDecimal.valueOf(.49)),
    BGLS("Sesame", BigDecimal.valueOf(.49));

    private final String variant;
    private final BigDecimal price;
}
