package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Bagel extends Item {
    private double price;
    public static HashSet<String> bagelsSkus;
    public HashMap<FillingType, Integer> fillings;
    public Bagel(BagelType bagelType) {
        super(bagelType);
        price = bagelType.getPrice();
        fillings = new HashMap<FillingType, Integer>();
    }
    private void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public void addFilling(FillingType fillingType) {
        Integer amount = fillings.get(fillingType);
        fillings.put(fillingType, amount == null ? 1 : amount + 1);
        setPrice(getPrice() + fillingType.getPrice());
    }
    public boolean removeFilling(FillingType fillingType) {
        if (fillings.containsKey(fillingType)) {
            fillings.put(fillingType, fillings.get(fillingType) - 1);
            if(fillings.get(fillingType) == 0)
                fillings.remove(fillingType);
            setPrice(getPrice() - fillingType.getPrice());
            return true;
        }
        return false;
    }
}
