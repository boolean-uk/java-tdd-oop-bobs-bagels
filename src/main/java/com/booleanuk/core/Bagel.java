package com.booleanuk.core;


import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class Bagel {
    private final BagelType type;
    private final Filling[] fillings;

    public Bagel(BagelType type, Filling... fillings) {
        this.type = type;
        this.fillings = fillings;
    }

    public BigDecimal price() {
        // TODO
        return null;
    }
}
