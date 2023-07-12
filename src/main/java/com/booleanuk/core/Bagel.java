package com.booleanuk.core;

import java.util.Comparator;

public class Bagel extends Item {
    private final BagelVariant variant;

    public Bagel(BagelVariant variant) {
        this.variant = variant;
    }

    enum BagelVariant {
        ONION("Onion"),
        PLAIN("Plain"),
        EVERYTHING("Everything"),
        SESAME("Sesame");

        BagelVariant(String variant) {
        }
    }

    public BagelVariant getVariant() {
        return variant;
    }
}
