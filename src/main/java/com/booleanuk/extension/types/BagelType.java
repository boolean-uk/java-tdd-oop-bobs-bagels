package com.booleanuk.extension.types;

public enum BagelType {
    PLAIN(39, "BGLP"), ONION(49, "BGLO"), EVERYTHING(49, "BGLE"), SESAME(49, "BGLS");

    private final long price;
    private final String code;

    BagelType(long price, String code) {
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
