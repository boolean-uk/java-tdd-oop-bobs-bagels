package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel implements Product {
    private final Triple<String, String, Float> bagelType;
    private final ArrayList<Triple<String, String, Float>> fillings;

    public Bagel(Triple<String, String, Float> bagelType, Triple<String, String, Float> fillingType) {
        this.bagelType = bagelType;
        this.fillings = new ArrayList<>();
        this.fillings.add(fillingType);
    }

    public Bagel(Triple<String, String, Float> bagelType, ArrayList<Triple<String, String, Float>> fillings) {
        this.bagelType = bagelType;
        this.fillings = new ArrayList<>();
        this.fillings.addAll(fillings);
    }

    public float calculateCost() {
        return bagelType.c() + (float) fillings.stream().mapToDouble(Triple::c).sum();
    }

    public float calculateBreadCost() {
        return bagelType.c();
    }
}
