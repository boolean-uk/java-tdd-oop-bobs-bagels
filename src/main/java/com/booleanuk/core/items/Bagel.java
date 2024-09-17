package com.booleanuk.core.items;

public class Bagel extends FillableProduct<BagelFilling> {
    public Bagel(String variant, double price) {
        super(variant, price);
    }

    @Override
    public boolean isType(Category type) {
        return type == Category.BAGEL;
    }
}
