package com.booleanuk.core;

import java.util.List;

public class Bagel extends Product{
    private List<Filling> fillings;

    public Bagel(String SKU, Double price, String variant, List<Filling> fillings) {
        super(SKU, price, variant);
        this.fillings = fillings;
    }

    public List<Filling> getFillings(){
        return fillings;
    }

    @Override
    public Product clone() {
        return null;
    }
}
