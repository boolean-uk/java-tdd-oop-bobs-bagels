package com.booleanuk.core.models;

import java.util.ArrayList;
import java.util.Arrays;

public class Bagel extends BasketItem {

    ArrayList<Filling> fillings;

    public Bagel(String variant, double price, String SKU) {
        super(variant, price, SKU);
        this.fillings = new ArrayList<>();
    }

    public void addFillings(Filling[] fillings) {
        this.fillings.addAll(Arrays.asList(fillings));
    }



    public ArrayList<Filling> getFillings() {
        return fillings;
    }

}
