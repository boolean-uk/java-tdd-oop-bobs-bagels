package com.booleanuk.core.products;

import java.util.ArrayList;
import java.util.List;

public class Bagel extends Product {

    private List<Filling> fillings;
    private BagelVariant variant;

    public Bagel(String SKU, double price) {
        super(SKU, price);
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
