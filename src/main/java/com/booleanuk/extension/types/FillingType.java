package com.booleanuk.extension.types;

public enum FillingType {
    BACON(12, "FILB"),
    EGG(12, "FILE"),
    CHEESE(12, "FILC"),
    CREAMCHEESE(12, "FILX"),
    SMOKEDSALMON(12, "FILS"),
    HAM(12, "FILH");

    private final long price;
    private final String code;

    FillingType(long price, String code) {
        this.price = price;
        this.code = code;
    }

    public long getPrice() {
        return price;
    }

    public String getCode() {
        return code;
    }
}
