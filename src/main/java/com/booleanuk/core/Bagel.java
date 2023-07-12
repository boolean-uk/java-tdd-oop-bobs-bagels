package com.booleanuk.core;

public class Bagel {
    private final BagelType type;

    public Bagel(BagelType type) {
        this.type = type;
    }

    enum BagelType {
        ONION("Onion"),
        PLAIN("Plain"),
        EVERYTHING("Everything"),
        SESAME("Sesame");

        BagelType(String type) {
        }
    }
}
