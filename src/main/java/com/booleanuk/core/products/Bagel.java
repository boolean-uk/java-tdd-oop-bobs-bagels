package com.booleanuk.core.products;

import java.util.List;

public class Bagel extends Product {

    private BagelVariant variant;
    private List<Filling> fillings;

    public Bagel(String SKU, double price) {
        super(SKU, price);
    }

    private double getPriceWithFilling() {
        return 0;
    }
}
