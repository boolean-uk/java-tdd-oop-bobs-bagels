package com.booleanuk.core;

public class Bagel {
    private final Triple<String, String, Float> bagelType;
    private final Triple<String, String, Float> fillingType;

    public Bagel(Triple<String, String, Float> bagelType, Triple<String, String, Float> fillingType) {
        this.bagelType = bagelType;
        this.fillingType = fillingType;
    }

    @Override
    public String toString() {
        return "Bagel{" +
                "bagelType=" + bagelType.b() +
                ", fillingType=" + fillingType.b() +
                ", cost=" + calculateCost() +
                '}';
    }

    public float calculateCost() {
        return bagelType.c() + fillingType.c();
    }
}
