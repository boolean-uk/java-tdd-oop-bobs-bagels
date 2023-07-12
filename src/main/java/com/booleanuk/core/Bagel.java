package com.booleanuk.core;


import java.math.BigDecimal;

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
