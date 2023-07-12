package com.booleanuk.core;

import java.math.BigDecimal;

public record Discount(
        Type type,
        BigDecimal price
) {
    public enum Type {
        SixOnion,
        TwelvePlain,
        SixEverything,
        BreakfastSet,
    }
}
