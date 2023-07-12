package com.booleanuk.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Bagel extends Product{
    private List<Filling> fillings;

    public Bagel(String SKU, Double price, String variant) {
        super(SKU, price, variant);
    }

    public List<Filling> getFillings(){
        return fillings;
    }
}
