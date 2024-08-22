package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bagel extends Product{

//    private List<Integer> fillings;

    public Bagel(float price, Enum variant) {
        super(price, variant);
//        this.fillings = new ArrayList<>();
    }

    @Override
    public ProductName setName() {
        return ProductName.BAGEL;
    }

//    public void addFilling(int filling) {
//        this.fillings.add(filling);
//    }
//
//    public List<Integer> getFillings() {
//        return fillings;
//    }
}
