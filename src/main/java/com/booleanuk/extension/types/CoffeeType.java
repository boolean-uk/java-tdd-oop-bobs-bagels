package com.booleanuk.extension.types;

public enum CoffeeType {
    BLACK(99, "COFB"),
    WHITE(119, "COFW"),
    CAPPUCCINO(129, "COFC"),
    LATTE(129, "COFL");

    private final long price;
    private final String code;

    CoffeeType(long price, String code) {
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
