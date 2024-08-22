package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bagel extends Product {

    private final Filling[] fillings;

    public Bagel(String sku, int price, String variant) {
        super(sku, price, variant);
        this.fillings = new Filling[2];
    }

    public boolean addFilling(Filling filling) {
        for (int i = 0; i < fillings.length; i++) {
            if (fillings[i] == null) {
                fillings[i] = filling;
                return true;
            }
        }
        return false;
    }

    public List<Filling> getFillings() {
        List<Filling> fillingList = new ArrayList<>();
        for (Filling filling : fillings) {
            if (filling != null) {
                fillingList.add(filling);
            }
        }
        return fillingList;
    }
}
