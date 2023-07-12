package com.booleanuk.core.products;

import java.util.ArrayList;
import java.util.List;

public class Bagel extends Product {

    private List<Filling> fillings;
    private BagelVariant variant;

    public Bagel(String SKU, double price) {
        super(SKU, price);
    }

    private double getPriceWithFilling() {
        return 0;
    }
}
