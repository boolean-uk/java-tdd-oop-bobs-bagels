package com.booleanuk.extension;

public class Filling extends Item {
    public Filling(SKU sku) {
        super(sku);
        if (!sku.getName().equals("Filling")) {
            throw new IllegalArgumentException("Wrong filling SKU");
        }
    }

    public Filling(String variant) {
        this(SKU.getConstant("Filling", variant));
    }
}
