package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bagel extends Product {

    private Filling[] fillings;

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

    public List<String> getFillings() {
        List<String> fillingList = new ArrayList<>();
        for (Filling filling : fillings) {
            if (filling != null) {
                fillingList.add(filling.getVariant());
            }
        }
        return fillingList;
    }


    @Override
    public int getPrice() {
        int price = super.getPrice();
        for (Filling filling : fillings) {
            if (filling != null) {
                price += filling.getPrice();
            }
        }
        return price;
    }
}
