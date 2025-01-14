package com.booleanuk.core;

enum SKU {
    BGLO,
    BGLP,
    BGLE,
    BGLS,
    COFB,
    COFW,
    COFC,
    COFL,
    FILB,
    FILE,
    FILC,
    FILX,
    FILS,
    FILH
}
public abstract class Item {
    protected SKU SKU;
    protected float price;
    protected String name;
    protected String variant;

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    String getVariant() {
        return variant;
    }

    SKU getSKU() {
        return SKU;
    }
}
