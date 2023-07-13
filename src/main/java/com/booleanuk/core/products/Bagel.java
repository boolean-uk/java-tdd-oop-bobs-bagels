package com.booleanuk.core.products;

import java.util.List;

public class Bagel extends Product {

    private BagelVariant variant;
    private List<Filling> fillings;

    public Bagel(String SKU, double price) {
        super(SKU, price);
    }

    public Bagel(String SKU, double price, BagelVariant variant) {
        super(SKU, price);
        this.variant = variant;
    }

    public double getPriceWithFilling() {
        return 0;
    }

    public BagelVariant getVariant() {
        return variant;
    }

    public List<Filling> getFillings() {
        return fillings;
    }


}
