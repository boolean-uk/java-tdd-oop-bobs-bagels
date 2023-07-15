package com.booleanuk.core;

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
        return filling == null ? super.getPrice() : super.getPrice().add(filling.getPrice());
    }

    public boolean addFilling(Filling filling) {
        if (this.filling == null) {
            this.filling = filling;
            return true;
        }
        return false;
    }

    public Filling getFilling() {
        return filling;
    }
}
