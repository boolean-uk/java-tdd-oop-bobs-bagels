package com.booleanuk.core;

public class Bagel {
    private Triple<String, String, Float> bagelType;
    private Triple<String, String, Float> fillingType;

    public Bagel(Triple<String, String, Float> bagelType, Triple<String, String, Float> fillingType) {
        this.bagelType = bagelType;
        this.fillingType = fillingType;
    }
}
