package com.booleanuk;

public class CountableBagel extends CountableItem {

    public CountableBagel(Bagel bagel, int amount) {
        super(bagel, amount);
    }

    public boolean holds(Bagel bagel) {
        Bagel b = (Bagel) super.getItem();
        return b.equals(bagel);
    }
}
