package com.booleanuk.extension;

import java.math.BigDecimal;

public class Bagel extends Item {
    private Filling filling;

    public Bagel(SKU sku) {
        super(sku);
    }

    public Bagel(String variant) {
        super(SKU.getConstant("Bagel", variant));
    }

    public Bagel(SKU sku, Filling filling) {
        super(sku);
        if (!sku.getName().equals("Bagel")) {
            throw new IllegalArgumentException("Wrong bagel SKU");
        }
        this.filling = filling;
    }

    public Bagel(String variant, Filling filling) {
        super(SKU.getConstant("Bagel", variant));
        this.filling = filling;
    }

    @Override
    public BigDecimal getPrice() {
        if (filling != null) {
            return super.getPrice().add(filling.getPrice());
        }
        return super.getPrice();
    }

    public Filling getFilling() {
        return filling;
    }
}
