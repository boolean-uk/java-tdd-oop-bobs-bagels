package com.booleanuk.extension;

import java.math.BigDecimal;
import java.util.Arrays;

public enum SKU {
    BGLO(BigDecimal.valueOf(0.49), "Bagel", "Onion"),
    BGLP(BigDecimal.valueOf(0.39), "Bagel", "Plain"),
    BGLE(BigDecimal.valueOf(0.49), "Bagel", "Everything"),
    BGLS(BigDecimal.valueOf(0.49), "Bagel", "Sesame"),
    COFB(BigDecimal.valueOf(0.99), "Coffee", "Black"),
    COFW(BigDecimal.valueOf(1.19), "Coffee", "White"),
    COFC(BigDecimal.valueOf(1.29), "Coffee", "Capuccino"),
    COFL(BigDecimal.valueOf(1.29), "Coffee", "Latte"),
    FILB(BigDecimal.valueOf(0.12), "Filling", "Bacon"),
    FILE(BigDecimal.valueOf(0.12), "Filling", "Egg"),
    FILC(BigDecimal.valueOf(0.12), "Filling", "Cheese"),
    FILX(BigDecimal.valueOf(0.12), "Filling", "Cream Cheese"),
    FILS(BigDecimal.valueOf(0.12), "Filling", "Smoked Salmon "),
    FILH(BigDecimal.valueOf(0.12), "Filling", "Ham");

    private final BigDecimal price;
    private final String name;
    private final String variant;

    SKU(BigDecimal price, String name, String variant) {
        this.price = price;
        this.name = name;
        this.variant = variant;
    }

    public static SKU getConstant(Item item) {
        return Arrays.stream(values())
                .filter(val -> val.getName().equals(item.getName()) && val.getVariant().equals(item.getVariant()))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public static SKU getConstant(String name, String variant) {
        return Arrays.stream(values())
                .filter(val -> val.getName().equals(name) && val.getVariant().equals(variant))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getVariant() {
        return variant;
    }
}
