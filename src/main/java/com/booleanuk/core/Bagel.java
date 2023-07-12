package com.booleanuk.core;

import java.math.BigDecimal;

public class Bagel extends Item {
    private Item filling;

    public Bagel(SKU sku) {
        super(sku);
    }

    public Bagel(SKU sku, Item filling) {
        super(sku);
        this.filling = filling;
    }

    @Override
    public BigDecimal getPrice() {
        return filling == null ? super.getPrice() : super.getPrice().add(filling.getPrice());
    }
}
