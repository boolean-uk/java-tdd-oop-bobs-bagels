package com.booleanuk;

public class CountableBagel extends CountableItem {
    private final Bagel bagel;

    public CountableBagel(Bagel bagel, int amount) {
        super(amount);
        this.bagel = bagel;
    }

    public boolean holds(Bagel item) {
        return this.bagel.equals(item);
    }

    public double getPrice() {
        return bagel.getPrice();
    }
}
